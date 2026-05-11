package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.mail.EmailBuilder;
import com.rays.mail.EmailMessage;
import com.rays.mail.EmailUtility;

/**
 * UserServiceImpl is the service implementation class for the User entity.
 * This class extends {@link BaseServiceImpl} and implements {@link UserServiceInt}
 * to provide business operations for UserDTO objects.
 * 
 * <p>This service handles user-related business logic such as authentication,
 * registration, password management, and user profile operations. It inherits
 * standard CRUD and search operations from BaseServiceImpl and adds
 * user-specific business logic.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

    /**
     * Finds a user by their login ID.
     *
     * @param login the login ID to search for
     * @param userContext the user context containing current user information
     * @return the UserDTO if found, or null if no user exists with the given login ID
     */
    @Transactional(readOnly = true)
    public UserDTO findByLoginId(String login, UserContext userContext) {
        return baseDao.findByUniqueKey("loginId", login, userContext);
    }

    /**
     * Registers a new user in the system.
     *
     * @param dto the UserDTO containing user details
     * @param userContext the user context containing current user information
     * @return the registered UserDTO with the generated ID
     */
    @Override
    public UserDTO register(UserDTO dto, UserContext userContext) {

        Long id = add(dto, userContext);
        
    	HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);

		EmailMessage msg = new EmailMessage();
		msg.setTo(dto.getLoginId());
		msg.setSubject("Registration is successful for ORS Project");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);


        return dto;
    }

    /**
     * Authenticates a user based on login ID and password.
     * Updates the last login timestamp and resets unsuccessful login attempts
     * upon successful authentication. Increments unsuccessful login attempts
     * on failure.
     *
     * @param loginId the login ID of the user
     * @param password the password to validate
     * @return the authenticated UserDTO if credentials are valid, or null otherwise
     */
    @Override
    public UserDTO authenticate(String loginId, String password) {

        UserDTO dto = findByLoginId(loginId, null);

        if (dto != null) {
            UserContext userContext = new UserContext(dto);
            if (password.equals(dto.getPassword())) {
                dto.setLastLogin(new Timestamp((new Date()).getTime()));
                dto.setUnsucessfullLoginAttempt(0);
                update(dto, userContext);
                return dto;
            } else {
                dto.setUnsucessfullLoginAttempt(1 + dto.getUnsucessfullLoginAttempt());
                update(dto, userContext);
            }
        }
        return null;
    }

    /**
     * Handles forgot password functionality.
     * Retrieves the user by login ID for password recovery.
     *
     * @param loginId the login ID of the user
     * @return the UserDTO if found, or null if no user exists with the given login ID
     */
    @Override
    public UserDTO forgotPassword(String loginId) {

        UserDTO dto = findByLoginId(loginId, null);
        if (dto == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());
		map.put("firstName", dto.getFirstName());
		map.put("lastName", dto.getLastName());

		String message = EmailBuilder.getForgetPasswordMessage(map);

		EmailMessage msg = new EmailMessage();
		msg.setTo(loginId);
		msg.setSubject("Rays ORS Password Reset");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);
        return dto;
    }

    /**
     * Changes the password for a user after validating the old password.
     *
     * @param loginId the login ID of the user
     * @param oldPassword the current password for verification
     * @param newPassword the new password to set
     * @param userContext the user context containing current user information
     * @return the updated UserDTO if password change is successful, or null if old password is invalid
     */
    @Override
    public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext) {

        UserDTO dto = findByLoginId(loginId, null);

        if (dto != null && oldPassword.equals(dto.getPassword())) {
            dto.setPassword(newPassword);
            update(dto, userContext);
            HashMap<String, String> map = new HashMap<String, String>();
    		map.put("login", dto.getLoginId());
    		map.put("password", dto.getPassword());
    		map.put("firstName", dto.getFirstName());
    		map.put("lastName", dto.getLastName());

    		String message = EmailBuilder.getChangePasswordMessage(map);

    		EmailMessage msg = new EmailMessage();
    		msg.setTo(dto.getLoginId());
    		msg.setSubject("Rays ORS Password has been changed Successfully.");
    		msg.setMessage(message);
    		msg.setMessageType(EmailMessage.HTML_MSG);

    		EmailUtility.sendMail(msg);

            return dto;
        } else {
            return null;
        }
    }
}