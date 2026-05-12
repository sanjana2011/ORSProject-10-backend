package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * FacultyDTO is the Data Transfer Object class for the Faculty entity.
 * This class extends {@link BaseDTO} and represents a faculty member in the system.
 * 
 * <p>This DTO stores faculty details including personal information (name, DOB,
 * gender, phone, email, qualification) and associated college, course, and subject
 * information. It implements the required methods for unique key identification
 * using email address.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_faculty")
public class FacultyDTO extends BaseDTO {

    /** The first name of the faculty member. */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** The last name of the faculty member. */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** The date of birth of the faculty member. */
    @Column(name = "dob")
    private Date dob;

    /** The gender of the faculty member. */
    @Column(name = "gender", length = 10)
    private String gender;

    /** The phone number of the faculty member. */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** The email address of the faculty member (unique identifier). */
    @Column(name = "email", length = 50)
    private String email;

    /** The qualification of the faculty member. */
    @Column(name = "qualification", length = 15)
    private String qualification;

    /** The ID of the college where the faculty member teaches. */
    @Column(name = "college_id", length = 50)
    private long collegeId;

    /** The name of the college where the faculty member teaches. */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    /** The ID of the course taught by the faculty member. */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** The name of the course taught by the faculty member. */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** The ID of the subject taught by the faculty member. */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** The name of the subject taught by the faculty member. */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    /**
     * Gets the first name of the faculty member.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the faculty member.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the faculty member.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the faculty member.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth of the faculty member.
     *
     * @return the date of birth
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the faculty member.
     *
     * @param dob the date of birth to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the gender of the faculty member.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the faculty member.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the phone number of the faculty member.
     *
     * @return the phone number
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone number of the faculty member.
     *
     * @param phoneNo the phone number to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the email address of the faculty member.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the faculty member.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the qualification of the faculty member.
     *
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets the qualification of the faculty member.
     *
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets the college ID where the faculty member teaches.
     *
     * @return the college ID
     */
    public long getCollegeId() {
        return collegeId;
    }

    /**
     * Sets the college ID where the faculty member teaches.
     *
     * @param collegeId the college ID to set
     */
    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the college name where the faculty member teaches.
     *
     * @return the college name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the college name where the faculty member teaches.
     *
     * @param collegeName the college name to set
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Gets the course ID taught by the faculty member.
     *
     * @return the course ID
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID taught by the faculty member.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course name taught by the faculty member.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name taught by the faculty member.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the subject ID taught by the faculty member.
     *
     * @return the subject ID
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID taught by the faculty member.
     *
     * @param subjectId the subject ID to set
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name taught by the faculty member.
     *
     * @return the subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name taught by the faculty member.
     *
     * @param subjectName the subject name to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The email address serves as the unique key for faculty members.
     *
     * @return "email" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "email";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the email address as the unique value
     */
    @Override
    public String getUniqueValue() {
        return email;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Email" as the display label
     */
    @Override
    public String getLabel() {
        return "Email";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Faculty" as the table name
     */
    @Override
    public String getTableName() {
        return "Faculty";
    }

    /**
     * Gets the value for dropdown display.
     * This implementation returns null as faculty members are not typically
     * displayed in dropdowns.
     *
     * @return null
     */
    @Override
    public String getValue() {
        return null;
    }
}