package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CollegeDTO;

/**
 * CollegeForm is a form class used for capturing college-related data.
 * This class extends {@link BaseForm} and contains fields for college details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate college information such as
 * name, address, state, city, and phone number before converting it to
 * a {@link CollegeDTO} object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class CollegeForm extends BaseForm {

    /** The name of the college. */
    @NotEmpty(message = "Name is required")
    private String name;

    /** The address of the college. */
    @NotEmpty(message = "Address is required")
    private String address;

    /** The state where the college is located. */
    @NotEmpty(message = "State is required")
    private String state;

    /** The city where the college is located. */
    @NotEmpty(message = "City is required")
    private String city;

    /** The phone number of the college. Must be exactly 10 digits. */
    @NotNull(message = "Phone No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
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
     * Converts the form data to a {@link CollegeDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated CollegeDTO object
     */
    @Override
    public BaseDTO getDto() {

        CollegeDTO dto = initDTO(new CollegeDTO());
        dto.setName(name);
        dto.setAddress(address);
        dto.setState(state);
        dto.setCity(city);
        dto.setPhoneNo(phoneNo);

        return dto;
    }
}