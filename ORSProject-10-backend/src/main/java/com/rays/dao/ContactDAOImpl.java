package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ContactDTO;

/**
 * ContactDAOImpl is the Data Access Object implementation for the Contact entity.
 * This class extends {@link BaseDAOImpl} and implements {@link ContactDAOInt}
 * to provide database operations for ContactDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for contacts,
 * including search by name, email, mobile number, and message.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class ContactDAOImpl extends BaseDAOImpl<ContactDTO> implements ContactDAOInt {

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of ContactDTO
     */
    @Override
    public Class<ContactDTO> getDTOClass() {
        return ContactDTO.class;
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * ContactDTO attributes including name, email, mobile number, and message.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(ContactDTO dto, CriteriaBuilder builder, Root<ContactDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (!isEmptyString(dto.getEmail())) {

            whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
        }

        if (!isEmptyString(dto.getMobileNo())) {

            whereCondition.add(builder.like(qRoot.get("mobile no"), dto.getMobileNo() + "%"));
        }

        if (!isEmptyString(dto.getMessage())) {

            whereCondition.add(builder.like(qRoot.get("message"), dto.getMessage() + "%"));
        }
        return whereCondition;
    }

}