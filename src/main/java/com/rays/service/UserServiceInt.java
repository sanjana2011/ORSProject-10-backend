package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * UserServiceInt is the service interface for the User entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on UserDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and adds user-specific business logic such as authentication,
 * registration, password management, and user lookup by login ID.</p>
 *
 * @author sanjana gangrade
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

    /**
     * Finds a user by their login ID.
     *
     * @param name the login ID to search for
     * @param userContext the user context containing current user information
     * @return the UserDTO if found, or null if no user exists with the given login ID
     */
    public UserDTO findByLoginId(String name, UserContext userContext);

    /**
     * Registers a new user in the system.
     *
     * @param dto the UserDTO containing user details
     * @param userContext the user context containing current user information
     * @return the registered UserDTO with the generated ID
     */
    public UserDTO register(UserDTO dto, UserContext userContext);

    /**
     * Authenticates a user based on login ID and password.
     *
     * @param loginId the login ID of the user
     * @param password the password to validate
     * @return the authenticated UserDTO if credentials are valid, or null otherwise
     */
    public UserDTO authenticate(String loginId, String password);
    
    /**
     * Handles forgot password functionality.
     * Retrieves the user by login ID for password recovery.
     *
     * @param loginId the login ID of the user
     * @return the UserDTO if found, or null if no user exists with the given login ID
     */
    public UserDTO forgotPassword(String loginId);

    /**
     * Changes the password for a user after validating the old password.
     *
     * @param loginId the login ID of the user
     * @param oldPassword the current password for verification
     * @param newPassword the new password to set
     * @param userContext the user context containing current user information
     * @return the updated UserDTO if password change is successful, or null if old password is invalid
     */
    public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);
    
}