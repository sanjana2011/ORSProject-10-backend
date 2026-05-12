package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * UserRegistrationForm is a form class used for capturing user registration data.
 * This class contains fields for user details with validation constraints
 * during the sign-up process.
 * 
 * <p>This form is used to collect and validate user information such as
 * name, login ID (email), password, date of birth, gender, and phone number
 * when a new user registers in the system. Unlike {@link UserForm}, this form
 * does not include role assignment as new users are assigned a default role
 * by the system.</p>
 *
 * @author sanjana gangrade
 */
public class UserRegistrationForm {

    /** The first name of the user. */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** The last name of the user. */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** The login ID (email) of the user. Must be a valid email format. */
    @Email
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** The password of the user. */
    @NotEmpty(message = "Password is required")
    private String password;

    /** The date of birth of the user. */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** The gender of the user. */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** The phone number of the user. Must be exactly 10 digits. */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

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
     * Gets the login ID (email) of the user.
     *
     * @return the login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login ID (email) of the user.
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
     * Gets the phone number of the user.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone the phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}