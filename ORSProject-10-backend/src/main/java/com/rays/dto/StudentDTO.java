package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * StudentDTO is the Data Transfer Object class for the Student entity.
 * This class extends {@link BaseDTO} and represents a student in the system.
 * 
 * <p>This DTO stores student details including enrollment number, name,
 * date of birth, contact information, and associated college details.
 * It implements the required methods for unique key identification using
 * enrollment number and provides full name for dropdown display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

    /** The enrollment number of the student (unique identifier). */
    @Column(name = "enrol_no", length = 20)
    private String enrolNo;

    /** The first name of the student. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** The last name of the student. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** The date of birth of the student. */
    @Column(name = "dob")
    private Date dob;

    /** The phone number of the student. */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** The email address of the student. */
    @Column(name = "email", length = 50)
    private String email;

    /** The ID of the college where the student is enrolled. */
    @Column(name = "college_id")
    private Long collegeId;

    /** The name of the college where the student is enrolled. */
    @Column(name = "college_name", length = 50)
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
     * Gets the unique key attribute name for this DTO.
     * The enrollment number serves as the unique key for students.
     *
     * @return "enrolNo" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "enrolNo";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the enrollment number as the unique value
     */
    @Override
    public String getUniqueValue() {
        return enrolNo;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Enroll No" as the display label
     */
    @Override
    public String getLabel() {
        return "Enroll No";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Student" as the table name
     */
    @Override
    public String getTableName() {
        return "Student";
    }

    /**
     * Gets the value for dropdown display.
     * Returns the full name (first name + last name) of the student.
     *
     * @return the full name of the student
     */
    @Override
    public String getValue() {
        return firstName + " " + lastName;
    }
}