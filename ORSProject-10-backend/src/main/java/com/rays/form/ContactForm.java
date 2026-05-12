package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ContactDTO;

/**
 * ContactForm is a form class used for capturing contact inquiry data.
 * This class extends {@link BaseForm} and contains fields for contact details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate contact information such as
 * name, email, mobile number, and message before converting it to a
 * {@link ContactDTO} object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class ContactForm extends BaseForm {

    /** The name of the person submitting the contact inquiry. */
    @NotEmpty(message = "Name is required")
    private String name;

    /** The email address of the person submitting the contact inquiry. */
    @NotEmpty(message = "Email is required")
    private String email;

    /** The mobile number of the person submitting the contact inquiry. */
    @NotEmpty(message = "Mobile no is required")
    private String mobileNo;

    /** The message content of the contact inquiry. */
    @NotEmpty(message = "Message no is required")
    private String message;

    /**
     * Gets the name of the person submitting the contact inquiry.
     *
     * @return the contact name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person submitting the contact inquiry.
     *
     * @param name the contact name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the person submitting the contact inquiry.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person submitting the contact inquiry.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the mobile number of the person submitting the contact inquiry.
     *
     * @return the mobile number
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the mobile number of the person submitting the contact inquiry.
     *
     * @param mobileNo the mobile number to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets the message content of the contact inquiry.
     *
     * @return the message content
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the contact inquiry.
     *
     * @param message the message content to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Converts the form data to a {@link ContactDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated ContactDTO object
     */
    @Override
    public BaseDTO getDto() {

        ContactDTO dto = initDTO(new ContactDTO());
        dto.setName(name);
        dto.setEmail(email);
        dto.setMobileNo(mobileNo);
        dto.setMessage(message);

        return dto;
    }

}