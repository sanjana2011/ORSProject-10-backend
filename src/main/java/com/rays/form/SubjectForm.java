package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

/**
 * SubjectForm is a form class used for capturing subject-related data.
 * This class extends {@link BaseForm} and contains fields for subject details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate subject information such as
 * associated course, subject name, and description before converting it to a
 * {@link SubjectDTO} object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class SubjectForm extends BaseForm {

    /** The ID of the course to which this subject belongs. Must be at least 1. */
    @NotNull(message = "Course is required")
    @Min(1)
    private Long courseId = 0L;

    /** The name of the course to which this subject belongs. */
    private String courseName;

    /** The name of the subject. */
    @NotEmpty(message = "Name is required")
    private String name;

    /** The description of the subject. */
    @NotEmpty(message = "Description is required")
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
     * Converts the form data to a {@link SubjectDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated SubjectDTO object
     */
    @Override
    public BaseDTO getDto() {

        SubjectDTO dto = initDTO(new SubjectDTO());

        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setName(name);
        dto.setDescription(description);

        return dto;
    }
}