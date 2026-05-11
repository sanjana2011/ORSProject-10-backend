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
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

/**
 * FacultyDAOImpl is the Data Access Object implementation for the Faculty entity.
 * This class extends {@link BaseDAOImpl} and implements {@link FacultyDAOInt}
 * to provide database operations for FacultyDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for faculty members,
 * including populating college, course, and subject names from their respective IDs,
 * and search by first name, email, college name, course name, and subject name.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

    /** Data Access Object for College operations. */
    @Autowired
    CollegeDAOInt collegeDao;

    /** Data Access Object for Course operations. */
    @Autowired
    CourseDAOInt courseDao;

    /** Data Access Object for Subject operations. */
    @Autowired
    SubjectDAOInt subjectDao;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of FacultyDTO
     */
    @Override
    public Class<FacultyDTO> getDTOClass() {
        return FacultyDTO.class;
    }

    /**
     * Populates the FacultyDTO with related entity names.
     * This method fetches college, course, and subject names based on their IDs
     * and sets them in the FacultyDTO for display purposes.
     *
     * @param dto the FacultyDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(FacultyDTO dto, UserContext userContext) {

        if (dto.getCollegeId() > 0) {
            CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId(), userContext);
            dto.setCollegeName(collegeDto.getName());
        }
        if (dto.getCourseId() > 0) {
            CourseDTO courseDto = courseDao.findByPK(dto.getCourseId(), userContext);
            dto.setCourseName(courseDto.getName());
        }
        if (dto.getSubjectId() > 0) {
            SubjectDTO subjectDto = subjectDao.findByPK(dto.getSubjectId(), userContext);
            dto.setSubjectName(subjectDto.getName());
        }
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * FacultyDTO attributes including first name, email, college name,
     * course name, and subject name.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();
        
        if (!isEmptyString(dto.getFirstName())) {

            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
        }
        
        if (!isEmptyString(dto.getEmail())) {

            whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
        }

        if (!isEmptyString(dto.getCollegeName())) {

            whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
        }

        if (!isEmptyString(dto.getCourseName())) {

            whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
        }

        if (!isEmptyString(dto.getSubjectName())) {

            whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
        }

        return whereCondition;
    }

}