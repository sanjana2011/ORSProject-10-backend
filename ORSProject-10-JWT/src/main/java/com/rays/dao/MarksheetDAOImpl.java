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
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

/**
 * MarksheetDAOImpl is the Data Access Object implementation for the Marksheet entity.
 * This class extends {@link BaseDAOImpl} and implements {@link MarksheetDAOInt}
 * to provide database operations for MarksheetDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for marksheets,
 * including populating student names from student IDs, search by name, roll number,
 * and student ID, as well as retrieving the merit list of top-performing students.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

    /** Data Access Object for Student operations. */
    @Autowired
    StudentDAOInt studentDao = null;

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of MarksheetDTO
     */
    @Override
    public Class<MarksheetDTO> getDTOClass() {
        return MarksheetDTO.class;
    }

    /**
     * Populates the MarksheetDTO with the student's full name.
     * This method fetches the student's first and last name based on student ID
     * and sets the full name in the MarksheetDTO for display purposes.
     *
     * @param dto the MarksheetDTO to populate
     * @param userContext the user context containing current user information
     */
    @Override
    protected void populate(MarksheetDTO dto, UserContext userContext) {
        if (dto.getStudentId() != null) {
            StudentDTO studentDTO = studentDao.findByPK(dto.getStudentId(), userContext);
            if (studentDTO != null) {
                dto.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
            }
        }
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * MarksheetDTO attributes including name, roll number, and student ID.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(MarksheetDTO dto, CriteriaBuilder builder, Root<MarksheetDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (!isEmptyString(dto.getRollNo())) {

            whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo() + "%"));
        }

        if (!isZeroNumber(dto.getStudentId())) {

            whereCondition.add(builder.equal(qRoot.get("studentId"), dto.getStudentId()));
        }

        return whereCondition;
    }
    
    /**
     * Retrieves the merit list of top-performing students.
     * This method fetches marksheets sorted by total marks (physics + chemistry + maths)
     * in descending order and returns the top 10 records.
     *
     * @return list of MarksheetDTO objects representing the merit list
     */
    public List<MarksheetDTO> getMeritList() {
        System.out.println("marksheetDao merit marksheett run start");
        // List list = super.runHQL("from MarksheetDTO order by (physics+chemistry+maths) desc limit 0,10", null);
        List list = super.marksheetMeritList("from MarksheetDTO order by (physics+chemistry+maths) desc", null);
        return list;
    }
}