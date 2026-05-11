package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * UserDTO is the Data Transfer Object class for the User entity.
 * This class extends {@link BaseDTO} and represents a system user with
 * authentication and authorization details.
 * 
 * <p>This DTO stores user details including personal information, login
 * credentials, role information, account status, login attempts, and
 * profile image reference. It implements the required methods for
 * unique key identification using login ID.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

    /** Constant representing active user status. */
    public static final String ACTIVE = "Active";
    
    /** Constant representing deactive user status. */
    public static final String DEACTIVE = "Deactive";
    
    /** Constant representing locked user status. */
    public static final String LOCKED = "Locked";

    /** The first name of the user. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** The last name of the user. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** The login ID (username) of the user (unique identifier). */
    @Column(name = "login_id", length = 50)
    private String loginId;

    /** The password of the user (stored in encoded format). */
    @Column(name = "password", length = 50)
    private String password;

    /** The role ID associated with the user. */
    @Column(name = "role_id")
    private Long roleId;

    /** The role name associated with the user. */
    @Column(name = "role_name", length = 50)
    private String roleName = null;

    /** The date of birth of the user. */
    @Column(name = "dob")
    private Date dob;

    /** The gender of the user. */
    @Column(name = "gender", length = 10)
    private String gender;

    /** The primary phone number of the user. */
    @Column(name = "phone", length = 50)
    private String phone;

    /** The alternate mobile number of the user. */
    @Column(name = "alternate_mobile", length = 50)
    private String alternateMobile;

    /** The account status of the user (Active, Deactive, Locked). */
    @Column(name = "status", length = 20)
    private String status;

    /** The timestamp of the user's last successful login. */
    @Column(name = "last_login")
    private Timestamp lastLogin;

    /** The number of unsuccessful login attempts by the user. */
    @Column(name = "unsucess_login")
    private Integer unsucessfullLoginAttempt = 0;

    /** The ID of the profile picture attachment associated with the user. */
    @Column(name = "image_id")
    private Long imageId;

    /**
     * Gets the first name of the user.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the login ID of the user.
     *
     * @return the login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login ID of the user.
     *
     * @param loginId the login ID to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role ID of the user.
     *
     * @return the role ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID of the user.
     *
     * @param roleId the role ID to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name of the user.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name of the user.
     *
     * @param roleName the role name to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the date of birth of the user.
     *
     * @return the date of birth
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the user.
     *
     * @param dob the date of birth to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the gender of the user.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the primary phone number of the user.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the primary phone number of the user.
     *
     * @param phone the phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the alternate mobile number of the user.
     *
     * @return the alternate mobile number
     */
    public String getAlternateMobile() {
        return alternateMobile;
    }

    /**
     * Sets the alternate mobile number of the user.
     *
     * @param alternateMobile the alternate mobile number to set
     */
    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    /**
     * Gets the account status of the user.
     *
     * @return the status (Active, Deactive, Locked)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the account status of the user.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the timestamp of the user's last successful login.
     *
     * @return the last login timestamp
     */
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the timestamp of the user's last successful login.
     *
     * @param lastLogin the last login timestamp to set
     */
    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Gets the number of unsuccessful login attempts by the user.
     *
     * @return the unsuccessful login attempt count
     */
    public Integer getUnsucessfullLoginAttempt() {
        return unsucessfullLoginAttempt;
    }

    /**
     * Sets the number of unsuccessful login attempts by the user.
     *
     * @param unsucessfullLoginAttempt the unsuccessful login attempt count to set
     */
    public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
        this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
    }

    /**
     * Gets the ID of the profile picture attachment.
     *
     * @return the image ID
     */
    public Long getImageId() {
        return imageId;
    }

    /**
     * Sets the ID of the profile picture attachment.
     *
     * @param imageId the image ID to set
     */
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    /**
     * Gets the full name of the user (first name + last name).
     *
     * @return the full name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The login ID serves as the unique key for users.
     *
     * @return "loginId" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "loginId";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the login ID as the unique value
     */
    @Override
    public String getUniqueValue() {
        return loginId;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Login Id" as the display label
     */
    @Override
    public String getLabel() {
        return "Login Id";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "User" as the table name
     */
    @Override
    public String getTableName() {
        return "User";
    }
    
    /**
     * Gets the value for dropdown display.
     * This implementation returns null as users are not typically
     * displayed in dropdowns.
     *
     * @return null
     */
    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return null;
    }
    
}