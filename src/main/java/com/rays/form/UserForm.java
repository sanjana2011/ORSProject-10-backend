package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

/**
 * UserForm is a form class used for capturing user-related data.
 * This class extends {@link BaseForm} and contains fields for user details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate user information such as
 * personal details, login credentials, role assignment, and account status
 * before converting it to a {@link UserDTO} object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class UserForm extends BaseForm {

    /** The first name of the user. */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** The last name of the user. */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** The login ID (username) of the user. */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** The password of the user. */
    @NotEmpty(message = "Password is required")
    private String password;

    /** The role ID associated with the user. Must be at least 1. */
    @NotNull(message = "Role is required")
    @Min(1)
    private Long roleId;

    /** The role name associated with the user. */
    private String roleName = null;

    /** The date of birth of the user. */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** The gender of the user. */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** The primary phone number of the user. Must be exactly 10 digits. */
    @NotNull(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    /** The alternate mobile number of the user. */
    @NotEmpty(message = "Alternate Mobile No is required")
    private String alternateMobile;

    /** The account status of the user (Active, Deactive, Locked). */
    @NotEmpty(message = "Status is required")
    private String status;

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
     * Converts the form data to a {@link UserDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated UserDTO object
     */
    @Override
    public BaseDTO getDto() {

        UserDTO dto = initDTO(new UserDTO());
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLoginId(loginId);
        dto.setPassword(password);
        dto.setRoleId(roleId);
        dto.setRoleName(roleName);
        dto.setDob(dob);
        dto.setGender(gender);
        dto.setPhone(phone);
        dto.setAlternateMobile(alternateMobile);
        dto.setStatus(status);

        return dto;
    }
}