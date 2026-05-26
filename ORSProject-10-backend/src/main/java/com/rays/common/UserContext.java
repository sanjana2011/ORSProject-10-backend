package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * UserContext class holds the current user's session information.
 * This class is used to store user details such as ID, login ID, name,
 * role information, and the complete UserDTO object. It is typically
 * populated from the session or security context and used throughout
 * the application for audit trails and authorization checks.
 *
 * @author sanjana gangrade
 */
public class UserContext {

    /** The ID of the current user. Default value is 0L. */
    private Long userId = 0L;
    
    /** The login ID of the current user. Default value is "root". */
    private String loginId = "root";
    
    /** The name of the current user. */
    private String name = null;
    
    /** The role ID of the current user. Default value is 0L. */
    private Long roleId = 0L;
    
    /** The role name of the current user. Default value is "root". */
    private String roleName = "root";

    /** The complete UserDTO object containing all user details. */
    private UserDTO userDTO = null;

    /**
     * Default constructor.
     * Creates an empty UserContext with default values.
     */
    public UserContext() {
    }

    /**
     * Constructs a UserContext from a UserDTO object.
     * Populates all fields from the provided DTO.
     *
     * @param dto the UserDTO containing user information
     */
    public UserContext(UserDTO dto) {
        this.userDTO = dto;
        this.userId = dto.getId();
        this.loginId = dto.getLoginId();
        this.name = dto.getName();
        this.roleId = dto.getRoleId();
        this.roleName = dto.getRoleName();
    }

    /**
     * Gets the user ID.
     *
     * @return the user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId the user ID to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the login ID.
     *
     * @return the login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login ID.
     *
     * @param loginId the login ID to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user name.
     *
     * @param name the user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the role ID.
     *
     * @return the role ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID.
     *
     * @param roleId the role ID to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName the role name to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the complete UserDTO object.
     *
     * @return the UserDTO object
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets the complete UserDTO object.
     *
     * @param userDTO the UserDTO object to set
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}