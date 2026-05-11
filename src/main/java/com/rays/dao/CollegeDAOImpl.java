package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CollegeDTO;

/**
 * CollegeDAOImpl is the Data Access Object implementation for the College entity.
 * This class extends {@link BaseDAOImpl} and implements {@link CollegeDAOInt}
 * to provide database operations for CollegeDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for colleges,
 * including search by name, city, state, address, and phone number.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of CollegeDTO
     */
    @Override
    public Class<CollegeDTO> getDTOClass() {
        return CollegeDTO.class;
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * CollegeDTO attributes including name, city, state, address, and phone number.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (!isEmptyString(dto.getCity())) {

            whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
        }

        if (!isEmptyString(dto.getState())) {

            whereCondition.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
        }

        if (!isEmptyString(dto.getAddress())) {

            whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
        }

        if (!isEmptyString(dto.getPhoneNo())) {

            whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
        }

        return whereCondition;
    }

}