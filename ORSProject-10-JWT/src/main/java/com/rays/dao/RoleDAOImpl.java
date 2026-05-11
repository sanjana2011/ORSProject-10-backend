package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOImpl is the Data Access Object implementation for the Role entity.
 * This class extends {@link BaseDAOImpl} and implements {@link RoleDAOInt}
 * to provide database operations for RoleDTO objects.
 * 
 * <p>This DAO handles CRUD operations and search functionality for roles,
 * including search by ID and name.</p>
 *
 * @author sanjana gangrade
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of RoleDTO
     */
    @Override
    public Class<RoleDTO> getDTOClass() {
        return RoleDTO.class;
    }

    /**
     * Builds the WHERE clause predicates for search criteria.
     * This method constructs search conditions based on the provided
     * RoleDTO attributes including ID and name.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    @Override
    protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isZeroNumber(dto.getId())) {

            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (!isEmptyString(dto.getName())) {

            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        return whereCondition;
    }
}