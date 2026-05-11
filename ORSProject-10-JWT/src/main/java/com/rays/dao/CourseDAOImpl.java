package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOImpl is the Data Access Object implementation for the Course entity.
 * This class extends {@link BaseDAOImpl} and implements {@link CourseDAOInt}
 * to provide database operations for CourseDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for courses,
 * including search by name, description, and duration.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt {

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of CourseDTO
     */
    @Override
    public Class<CourseDTO> getDTOClass() {
        return CourseDTO.class;
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * CourseDTO attributes including name, description, and duration.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (!isEmptyString(dto.getDescription())) {

            whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
        }

        if (!isEmptyString(dto.getDuration())) {

            whereCondition.add(builder.like(qRoot.get("duration"), dto.getDuration() + "%"));
        }

        return whereCondition;
    }

}