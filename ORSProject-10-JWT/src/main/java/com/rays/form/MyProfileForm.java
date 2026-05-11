package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * MyProfileForm is a form class used for capturing user profile data.
 * This class contains fields for personal information with validation constraints.
 * 
 * <p>This form is used to collect and validate user profile details such as
 * name, login ID, gender, phone number, and date of birth during profile
 * update operations.</p>
 *
 * @author sanjana gangrade
 */
public class MyProfileForm {

    /** The first name of the user. */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** The last name of the user. */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** The login ID (username) of the user. */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** The gender of the user. */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** The phone number of the user. Must be exactly 10 digits. */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    /** The date of birth of the user. */
    @NotNull(message = "Date of birth is required")
    private Date dob;

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
}