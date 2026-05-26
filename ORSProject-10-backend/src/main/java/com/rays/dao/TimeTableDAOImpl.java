package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableDAOImpl is the Data Access Object implementation for the TimeTable entity.
 * This class extends {@link BaseDAOImpl} and implements {@link TimeTableDAOInt}
 * to provide database operations for TimeTableDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for timetables,
 * including populating subject names from subject IDs and course names from
 * course IDs, and search by subject name and course name.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class TimeTableDAOImpl extends BaseDAOImpl<TimeTableDTO> implements TimeTableDAOInt {

    /** Data Access Object for Subject operations. */
    @Autowired
    SubjectDAOInt subjectService;

    /** Data Access Object for Course operations. */
    @Autowired
    CourseDAOInt courseService;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of TimeTableDTO
     */
    @Override
    public Class<TimeTableDTO> getDTOClass() {
        return TimeTableDTO.class;
    }

    /**
     * Populates the TimeTableDTO with subject and course names.
     * This method fetches subject name based on subject ID and course name
     * based on course ID, and sets them in the TimeTableDTO for display purposes.
     *
     * @param dto the TimeTableDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(TimeTableDTO dto, UserContext userContext) {

        SubjectDTO subjectDto = subjectService.findByPK(dto.getSubjectId(), userContext);
        if (subjectDto != null) {
            dto.setSubjectName(subjectDto.getName());
        }

        CourseDTO courseDto = courseService.findByPK(dto.getCourseId(), userContext);
        if (courseDto != null) {
            dto.setCourseName(courseDto.getName());
        }
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * TimeTableDTO attributes including subject name and course name.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(TimeTableDTO dto, CriteriaBuilder builder, Root<TimeTableDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getSubjectName())) {

            whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
        }
        if (!isEmptyString(dto.getCourseName())) {

            whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
        }
        return whereCondition;
    }
}