package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableForm is a form class used for capturing timetable-related data.
 * This class extends {@link BaseForm} and contains fields for timetable details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate timetable information such as
 * associated course, subject, exam date, exam time, semester, and description
 * before converting it to a {@link TimeTableDTO} object for database operations.</p>
 *
 * @author sanjana gangrade
 */
public class TimeTableForm extends BaseForm {

    /** The ID of the course for which the timetable is created. Must be at least 1. */
    @NotNull(message = "Course is required")
    @Min(1)
    private Long courseId = 0L;

    /** The name of the course for which the timetable is created. */
    private String courseName;

    /** The ID of the subject for which the timetable is created. Must be at least 1. */
    @NotNull(message = "Subject is required")
    @Min(1)
    private Long subjectId = 0L;

    /** The name of the subject for which the timetable is created. */
    private String subjectName;

    /** The date of the exam or class. */
    @NotNull(message = "Exam Date is required")
    private Date examDate;

    /** The time of the exam or class. */
    @NotEmpty(message = "Exam Time is required")
    private String examTime;

    /** The semester for which the timetable is created. */
    @NotEmpty(message = "Semester is required")
    private String semester;

    /** The description of the timetable entry. */
    @NotEmpty(message = "Description is required")
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
     * Converts the form data to a {@link TimeTableDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated TimeTableDTO object
     */
    @Override
    public BaseDTO getDto() {

        TimeTableDTO dto = initDTO(new TimeTableDTO());
        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
        dto.setExamDate(examDate);
        dto.setExamTime(examTime);
        dto.setSemester(semester);
        dto.setDescription(description);

        return dto;
    }
}