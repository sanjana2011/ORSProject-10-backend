package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

/**
 * StudentForm is a form class used for capturing student-related data.
 * This class extends {@link BaseForm} and contains fields for student details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate student information such as
 * enrollment number, name, date of birth, contact details, and associated
 * college before converting it to a {@link StudentDTO} object for database
 * operations.</p>
 *
 * @author sanjana gangrade
 */
public class StudentForm extends BaseForm {

    /** The enrollment number of the student. */
    @NotEmpty(message = "Enroll No is required")
    private String enrolNo;

    /** The first name of the student. */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** The last name of the student. */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** The date of birth of the student. */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** The phone number of the student. Must be exactly 10 digits. */
    @NotNull(message = "Phone No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phoneNo;

    /** The email address of the student. Must be a valid email format. */
    @NotEmpty(message = "Email ID is required")
    @Email
    private String email;

    /** The ID of the college where the student is enrolled. Must be at least 1. */
    @NotNull(message = "College Name is required")
    @Min(1)
    private Long collegeId;

    /** The name of the college where the student is enrolled. */
    private String collegeName;

    /**
     * Gets the enrollment number of the student.
     *
     * @return the enrollment number
     */
    public String getEnrolNo() {
        return enrolNo;
    }

    /**
     * Sets the enrollment number of the student.
     *
     * @param enrolNo the enrollment number to set
     */
    public void setEnrolNo(String enrolNo) {
        this.enrolNo = enrolNo;
    }

    /**
     * Gets the first name of the student.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth of the student.
     *
     * @return the date of birth
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the student.
     *
     * @param dob the date of birth to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the phone number of the student.
     *
     * @return the phone number
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone number of the student.
     *
     * @param phoneNo the phone number to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the email address of the student.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the college ID where the student is enrolled.
     *
     * @return the college ID
     */
    public Long getCollegeId() {
        return collegeId;
    }

    /**
     * Sets the college ID where the student is enrolled.
     *
     * @param collegeId the college ID to set
     */
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the college name where the student is enrolled.
     *
     * @return the college name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name where the student is enrolled.
     *
     * @param collegeName the college name to set
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Converts the form data to a {@link StudentDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated StudentDTO object
     */
    @Override
    public BaseDTO getDto() {

        StudentDTO dto = initDTO(new StudentDTO());

        dto.setEnrolNo(enrolNo);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDob(dob);
        dto.setPhoneNo(phoneNo);
        dto.setEmail(email);
        dto.setCollegeId(collegeId);
        dto.setCollegeName(collegeName);

        return dto;
    }
}