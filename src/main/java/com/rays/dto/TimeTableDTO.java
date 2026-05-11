package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * TimeTableDTO is the Data Transfer Object class for the TimeTable entity.
 * This class extends {@link BaseDTO} and represents a timetable entry for
 * exams or class schedules.
 * 
 * <p>This DTO stores timetable details including associated course and subject
 * information, exam date and time, semester, and description. It implements
 * the required methods for unique key identification using course name.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

    /** The ID of the course for which the timetable is created. */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** The name of the course for which the timetable is created. */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** The ID of the subject for which the timetable is created. */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** The name of the subject for which the timetable is created. */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    /** The date of the exam or class. */
    @Column(name = "exam_date")
    private Date examDate;

    /** The time of the exam or class. */
    @Column(name = "exam_time", length = 50)
    private String examTime;

    /** The semester for which the timetable is created. */
    @Column(name = "semester", length = 30)
    private String semester;

    /** The description of the timetable entry. */
    @Column(name = "description", length = 50)
    private String description;

    /**
     * Gets the course ID for which the timetable is created.
     *
     * @return the course ID
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID for which the timetable is created.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course name for which the timetable is created.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name for which the timetable is created.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the subject ID for which the timetable is created.
     *
     * @return the subject ID
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID for which the timetable is created.
     *
     * @param subjectId the subject ID to set
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name for which the timetable is created.
     *
     * @return the subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name for which the timetable is created.
     *
     * @param subjectName the subject name to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Gets the date of the exam or class.
     *
     * @return the exam date
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * Sets the date of the exam or class.
     *
     * @param examDate the exam date to set
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * Gets the time of the exam or class.
     *
     * @return the exam time
     */
    public String getExamTime() {
        return examTime;
    }

    /**
     * Sets the time of the exam or class.
     *
     * @param examTime the exam time to set
     */
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    /**
     * Gets the semester for which the timetable is created.
     *
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester for which the timetable is created.
     *
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the description of the timetable entry.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the timetable entry.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * The course name serves as the unique key for timetables.
     *
     * @return "courseName" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "courseName";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the course name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return courseName;
    }

    /**
     * Gets the display label for this DTO.
     * This implementation returns null as timetables may not have a specific label.
     *
     * @return null
     */
    @Override
    public String getLabel() {
        return null;
    }

    /**
     * Gets the table name associated with this DTO.
     *
     * @return "TimeTable" as the table name
     */
    @Override
    public String getTableName() {
        return "TimeTable";
    }

    /**
     * Gets the value for dropdown display.
     * This implementation returns null as timetables are not typically
     * displayed in dropdowns.
     *
     * @return null
     */
    @Override
    public String getValue() {
        return null;
    }
}