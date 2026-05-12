package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CourseDTO;

/**
 * CourseForm is a form class used for capturing course-related data.
 * This class extends {@link BaseForm} and contains fields for course details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate course information such as
 * name, duration, and description before converting it to a {@link CourseDTO}
 * object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class CourseForm extends BaseForm {

    /** The name of the course. */
    @NotEmpty(message = "Name is required")
    private String name;

    /** The duration of the course (e.g., 3 years, 6 months). */
    @NotEmpty(message = "Duration is required")
    private String duration;

    /** The description of the course. */
    @NotEmpty(message = "Description is required")
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
     * Converts the form data to a {@link CourseDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated CourseDTO object
     */
    @Override
    public BaseDTO getDto() {

        CourseDTO dto = initDTO(new CourseDTO());
        dto.setName(name);
        dto.setDuration(duration);
        dto.setDescription(description);

        return dto;
    }

}