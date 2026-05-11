package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * MarksheetDTO is the Data Transfer Object class for the Marksheet entity.
 * This class extends {@link BaseDTO} and represents a student's marksheet
 * containing subject-wise marks.
 * 
 * <p>This DTO stores marksheet details including roll number, student ID,
 * student name, and marks in physics, chemistry, and mathematics. It implements
 * the required methods for unique key identification using roll number.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

    /** The roll number of the student (unique identifier). */
    @Column(name = "roll_no", length = 20)
    protected String rollNo = null;

    /** The ID of the student associated with this marksheet. */
    @Column(name = "student_id")
    protected Long studentId;

    /** The name of the student. */
    @Column(name = "name", length = 50)
    protected String name = null;

    /** The marks obtained in Physics. */
    @Column(name = "physics")
    protected Integer physics;

    /** The marks obtained in Chemistry. */
    @Column(name = "chemistry")
    protected Integer chemistry;

    /** The marks obtained in Mathematics. */
    @Column(name = "maths")
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
     * Gets the unique key attribute name for this DTO.
     * The roll number serves as the unique key for marksheets.
     *
     * @return "rollNo" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "rollNo";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the roll number as the unique value
     */
    @Override
    public String getUniqueValue() {
        return rollNo;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Roll No" as the display label
     */
    @Override
    public String getLabel() {
        return "Roll No";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Marksheet" as the table name
     */
    @Override
    public String getTableName() {
        return "Marksheet";
    }

    /**
     * Gets the value for dropdown display.
     * This implementation returns null as marksheets are not typically
     * displayed in dropdowns.
     *
     * @return null
     */
    @Override
    public String getValue() {
        return null;
    }
}