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

/**
 * SubjectDAOImpl is the Data Access Object implementation for the Subject entity.
 * This class extends {@link BaseDAOImpl} and implements {@link SubjectDAOInt}
 * to provide database operations for SubjectDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for subjects,
 * including populating course names from course IDs, and search by subject
 * name and course name.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

    /** Data Access Object for Course operations. */
    @Autowired
    CourseDAOInt courseDao;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of SubjectDTO
     */
    @Override
    public Class<SubjectDTO> getDTOClass() {
        return SubjectDTO.class;
    }

    /**
     * Populates the SubjectDTO with the course name.
     * This method fetches the course name based on course ID
     * and sets it in the SubjectDTO for display purposes.
     *
     * @param dto the SubjectDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(SubjectDTO dto, UserContext userContext) {
        if (dto.getCourseId() != 0) {
            CourseDTO courseDTO = courseDao.findByPK(dto.getCourseId(), userContext);
            if (courseDTO != null) {
                dto.setCourseName(courseDTO.getName());
            }
        }
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * SubjectDTO attributes including subject name and course name.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (!isEmptyString(dto.getCourseName())) {

            whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
        }

        return whereCondition;
    }
}