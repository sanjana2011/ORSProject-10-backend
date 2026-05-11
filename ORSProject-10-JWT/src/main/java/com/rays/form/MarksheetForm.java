package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetForm is a form class used for capturing marksheet-related data.
 * This class extends {@link BaseForm} and contains fields for student marks
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate marksheet information such as
 * roll number, student ID, student name, and marks in physics, chemistry,
 * and mathematics before converting it to a {@link MarksheetDTO} object
 * for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class MarksheetForm extends BaseForm {

    /** The roll number of the student. */
    @NotEmpty(message = "Roll No is required")
    protected String rollNo = null;

    /** The ID of the student associated with this marksheet. Must be at least 1. */
    @NotNull(message = "Student Name is required")
    @Min(1)
    protected Long studentId;

    /** The name of the student. */
    protected String name = null;

    /** The marks obtained in Physics. Must be between 0 and 99 inclusive. */
    @NotNull(message = "Physics is required")
    @Max(99)
    @Min(0)
    protected Integer physics;

    /** The marks obtained in Chemistry. Must be between 0 and 99 inclusive. */
    @NotNull(message = "Chemistry is required")
    @Max(99)
    @Min(0)
    protected Integer chemistry;

    /** The marks obtained in Mathematics. Must be between 0 and 99 inclusive. */
    @NotNull(message = "Maths is required")
    @Max(99)
    @Min(0)
    protected Integer maths;

    /**
     * Gets the roll number of the student.
     *
     * @return the roll number
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     * Sets the roll number of the student.
     *
     * @param rollNo the roll number to set
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Gets the student ID associated with this marksheet.
     *
     * @return the student ID
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID associated with this marksheet.
     *
     * @param studentId the student ID to set
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the name of the student.
     *
     * @return the student name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name the student name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the marks obtained in Physics.
     *
     * @return the physics marks
     */
    public Integer getPhysics() {
        return physics;
    }

    /**
     * Sets the marks obtained in Physics.
     *
     * @param physics the physics marks to set
     */
    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    /**
     * Gets the marks obtained in Chemistry.
     *
     * @return the chemistry marks
     */
    public Integer getChemistry() {
        return chemistry;
    }

    /**
     * Sets the marks obtained in Chemistry.
     *
     * @param chemistry the chemistry marks to set
     */
    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    /**
     * Gets the marks obtained in Mathematics.
     *
     * @return the mathematics marks
     */
    public Integer getMaths() {
        return maths;
    }

    /**
     * Sets the marks obtained in Mathematics.
     *
     * @param maths the mathematics marks to set
     */
    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    /**
     * Converts the form data to a {@link MarksheetDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated MarksheetDTO object
     */
    @Override
    public BaseDTO getDto() {

        MarksheetDTO dto = initDTO(new MarksheetDTO());
        dto.setRollNo(rollNo);
        dto.setName(name);
        dto.setStudentId(studentId);
        dto.setPhysics(physics);
        dto.setChemistry(chemistry);
        dto.setMaths(maths);

        return dto;
    }
}