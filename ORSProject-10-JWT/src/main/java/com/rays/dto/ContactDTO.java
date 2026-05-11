package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * ContactDTO is the Data Transfer Object class for the Contact entity.
 * This class extends {@link BaseDTO} and represents a contact message or inquiry
 * submitted through the system.
 * 
 * <p>This DTO stores contact details including name, email, mobile number,
 * and message content. It implements the required methods for unique key
 * identification and dropdown display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_contact")
public class ContactDTO extends BaseDTO {

    /** The name of the person submitting the contact inquiry. */
    @Column(name = "name", length = 50)
    private String name;

    /** The email address of the person submitting the contact inquiry. */
    @Column(name = "email", length = 50)
    private String email;

    /** The mobile number of the person submitting the contact inquiry. */
    @Column(name = "mobile_no", length = 15)
    private String mobileNo;

    /** The message content of the contact inquiry. */
    @Column(name = "message", length = 255)
    private String message;

    // ---------- Getters & Setters ----------

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

    // ---------- BaseDTO Overrides ----------

    /**
     * Gets the value for dropdown display.
     *
     * @return the contact name
     */
    @Override
    public String getValue() {
        return name;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The contact name serves as the unique key.
     *
     * @return "name" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the contact name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Contact" as the display label
     */
    @Override
    public String getLabel() {
        return "Contact";
    }

    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Contact" as the table name
     */
    @Override
    public String getTableName() {
        return "Contact";
    }
}