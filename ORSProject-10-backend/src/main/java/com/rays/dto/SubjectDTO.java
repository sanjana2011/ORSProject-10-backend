package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * SubjectDTO is the Data Transfer Object class for the Subject entity.
 * This class extends {@link BaseDTO} and represents a subject offered in a course.
 * 
 * <p>This DTO stores subject details including associated course information,
 * subject name, and description. It implements the required methods for
 * unique key identification using subject name and dropdown display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_subject")
public class SubjectDTO extends BaseDTO {

    /** The ID of the course to which this subject belongs. */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** The name of the course to which this subject belongs. */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** The name of the subject. */
    @Column(name = "name", length = 50)
    private String name;

    /** The description of the subject. */
    @Column(name = "description", length = 50)
    private String description;

    /**
     * Gets the course ID to which this subject belongs.
     *
     * @return the course ID
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID to which this subject belongs.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course name to which this subject belongs.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name to which this subject belongs.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the name of the subject.
     *
     * @return the subject name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the subject.
     *
     * @param name the subject name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the subject.
     *
     * @return the subject description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the subject.
     *
     * @param description the subject description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The subject name serves as the unique key.
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
     * @return the subject name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Subject Name" as the display label
     */
    @Override
    public String getLabel() {
        return "Subject Name";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Subject" as the table name
     */
    @Override
    public String getTableName() {
        return "Subject";
    }

    /**
     * Gets the value for dropdown display.
     *
     * @return the subject name
     */
    @Override
    public String getValue() {
        return name;
    }
}