package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

/**
 * UserDAOImpl is the Data Access Object implementation for the User entity.
 * This class extends {@link BaseDAOImpl} and implements {@link UserDAOInt}
 * to provide database operations for UserDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for users,
 * including populating role names from role IDs, managing last login and
 * profile image information, and search by first name, login ID, role ID,
 * date of birth, and status.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

    /** Data Access Object for Role operations. */
    @Autowired
    RoleDAOInt roleDao;

    /** Data Access Object for Attachment operations (profile pictures). */
    @Autowired
    AttachmentDAOInt attachmentDao;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of UserDTO
     */
    @Override
    public Class<UserDTO> getDTOClass() {
        return UserDTO.class;
    }

    /**
     * Populates the UserDTO with related entity information.
     * This method fetches and sets:
     * <ul>
     *   <li>Role name based on role ID</li>
     *   <li>Last login timestamp from the existing record</li>
     *   <li>Image ID for profile picture</li>
     * </ul>
     *
     * @param dto the UserDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(UserDTO dto, UserContext userContext) {

        if (dto.getRoleId() != null && dto.getRoleId() > 0) {
            RoleDTO roleDTO = roleDao.findByPK(dto.getRoleId(), userContext);
            if (roleDTO != null) {
                dto.setRoleName(roleDTO.getName());
            }
        }

        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO user = findByPK(dto.getId(), userContext);
            if (user != null) {
                dto.setLastLogin(user.getLastLogin());
            }
        }

        if (dto.getId() != null && dto.getId() > 0) {
            UserDTO userData = findByPK(dto.getId(), null);
            if (userData != null) {
                dto.setImageId(userData.getImageId());
            }
        }
    }
    
    /**
     * Deletes a user and their associated profile picture attachment.
     * This method first deletes the user's profile image (if exists)
     * before deleting the user record.
     *
     * @param dto the UserDTO to delete
     * @param userContext the user context containing current user information
     */
    @Override
    public void delete(UserDTO dto, UserContext userContext) {
        if (dto.getImageId() != null && dto.getImageId() > 0) {
            attachmentDao.delete(attachmentDao.findByPK(dto.getImageId(), null), null);
        }
        super.delete(dto, userContext);
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * UserDTO attributes including first name, login ID, role ID,
     * date of birth, and status.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getFirstName())) {

            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
        }
        if (!isEmptyString(dto.getLoginId())) {

            whereCondition.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
        }
        if (!isZeroNumber(dto.getRoleId())) {

            whereCondition.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
        }
        if (isNotNull(dto.getDob())) {

            whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
        }
        if (!isEmptyString(dto.getStatus())) {

            whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
        }
        return whereCondition;
    }
    
}