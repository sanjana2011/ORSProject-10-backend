package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CourseDTO is the Data Transfer Object class for the Course entity.
 * This class extends {@link BaseDTO} and represents a course offered in the system.
 * 
 * <p>This DTO stores course details including name, duration, and description.
 * It implements the required methods for unique key identification and dropdown
 * display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_course")
public class CourseDTO extends BaseDTO {

    /** The name of the course. */
    @Column(name = "name", length = 50)
    private String name;

    /** The duration of the course (e.g., 3 years, 6 months). */
    @Column(name = "duration", length = 50)
    private String duration;

    /** The description of the course. */
    @Column(name = "description", length = 50)
    private String description;

    /**
     * Gets the name of the course.
     *
     * @return the course name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name the course name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the duration of the course.
     *
     * @return the course duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the course.
     *
     * @param duration the course duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the description of the course.
     *
     * @return the course description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     *
     * @param description the course description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The course name serves as the unique key.
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
     * @return the course name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Course Name" as the display label
     */
    @Override
    public String getLabel() {
        return "Course Name";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Course" as the table name
     */
    @Override
    public String getTableName() {
        return "Course";
    }

    /**
     * Gets the value for dropdown display.
     *
     * @return the course name
     */
    @Override
    public String getValue() {
        return name;
    }
}