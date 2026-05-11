package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CollegeDTO is the Data Transfer Object class for the College entity.
 * This class extends {@link BaseDTO} and represents a college in the system.
 * 
 * <p>This DTO stores college details including name, address, state, city,
 * and phone number. It implements the required methods for unique key
 * identification and dropdown display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

    /** The name of the college. */
    @Column(name = "name", length = 50)
    private String name;

    /** The address of the college. */
    @Column(name = "address", length = 50)
    private String address;

    /** The state where the college is located. */
    @Column(name = "state", length = 50)
    private String state;

    /** The city where the college is located. */
    @Column(name = "city", length = 50)
    private String city;

    /** The phone number of the college. */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /**
     * Gets the name of the college.
     *
     * @return the college name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the college.
     *
     * @param name the college name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the college.
     *
     * @return the college address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the college.
     *
     * @param address the college address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the state where the college is located.
     *
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state where the college is located.
     *
     * @param state the state name to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city where the college is located.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the college is located.
     *
     * @param city the city name to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the phone number of the college.
     *
     * @return the phone number
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone number of the college.
     *
     * @param phoneNo the phone number to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The college name serves as the unique key.
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
     * @return the college name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "College Name" as the display label
     */
    @Override
    public String getLabel() {
        return "College Name";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "College" as the table name
     */
    @Override
    public String getTableName() {
        return "College";
    }

    /**
     * Gets the value for dropdown display.
     *
     * @return the college name
     */
    @Override
    public String getValue() {
        return name;
    }
}