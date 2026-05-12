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
import com.rays.dto.StudentDTO;

/**
 * StudentDAOImpl is the Data Access Object implementation for the Student entity.
 * This class extends {@link BaseDAOImpl} and implements {@link StudentDAOInt}
 * to provide database operations for StudentDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for students,
 * including populating college names from college IDs, and search by enrollment
 * number, first name, college name, email, date of birth, and phone number.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

    /** Data Access Object for College operations. */
    @Autowired
    CollegeDAOInt collegeService = null;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of StudentDTO
     */
    @Override
    public Class<StudentDTO> getDTOClass() {
        return StudentDTO.class;
    }

    /**
     * Populates the StudentDTO with the college name.
     * This method fetches the college name based on college ID
     * and sets it in the StudentDTO for display purposes.
     *
     * @param dto the StudentDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(StudentDTO dto, UserContext userContext) {
        CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId(), userContext);
        if (collegeDTO != null) {
            dto.setCollegeName(collegeDTO.getName());
        }
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * StudentDTO attributes including enrollment number, first name,
     * college name, email, date of birth, and phone number.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getEnrolNo())) {

            whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
        }
        
        if (!isEmptyString(dto.getFirstName())) {

            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
        }

        if (!isEmptyString(dto.getCollegeName())) {

            whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
        }

        if (!isEmptyString(dto.getEmail())) {

            whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
        }

        if (isNotNull(dto.getDob())) {

            whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
        }

        if (!isEmptyString(dto.getPhoneNo())) {
            whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
        }

        return whereCondition;
    }
}