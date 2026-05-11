
package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Base Data Access Object implementation that provides common CRUD operations
 * and search functionality for all entities.
 * This abstract class implements the {@link BaseDAOInt} interface and provides
 * generic methods for database operations using JPA.
 *
 * @param <T> the DTO type that extends {@link BaseDTO}
 * @author sanjana gangrade
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

    /** The EntityManager for performing JPA operations. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Sets the EntityManager instance.
     *
     * @param entityManager the EntityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Gets the DTO class type for this DAO implementation.
     *
     * @return the Class object of the DTO
     */
    public abstract Class<T> getDTOClass();

    /**
     * Builds the WHERE clause predicates for search criteria.
     *
     * @param dto the DTO containing search criteria
     * @param builder the CriteriaBuilder instance
     * @param qRoot the Root instance for the query
     * @return list of predicates for the WHERE clause
     */
    protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

    /**
     * Populates additional fields or performs pre-save/pre-update operations.
     * This method can be overridden by subclasses to add custom logic.
     *
     * @param dto the DTO to populate
     * @param userContext the user context containing current user information
     */
    protected void populate(T dto, UserContext userContext) {
    }

    /**
     * Adds a new record to the database.
     * Sets created by, modified by, and timestamp fields before persisting.
     *
     * @param dto the DTO to add
     * @param userContext the user context containing current user information
     * @return the ID of the newly added record
     */
    public long add(T dto, UserContext userContext) {
        // ✅ FIX: userContext null check
        if (userContext != null) {
            dto.setCreatedBy(userContext.getLoginId());
            dto.setModifiedBy(userContext.getLoginId());
        }
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        populate(dto, userContext);
        entityManager.persist(dto);
        return dto.getId();
    }

    /**
     * Updates an existing record in the database.
     * Sets modified by and timestamp fields before updating.
     *
     * @param dto the DTO to update
     * @param userContext the user context containing current user information
     */
    public void update(T dto, UserContext userContext) {
        // ✅ FIX: userContext null check
        if (userContext != null) {
            dto.setModifiedBy(userContext.getLoginId());
        }
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        populate(dto, userContext);
        entityManager.merge(dto);
    }

    /**
     * Deletes a record from the database.
     *
     * @param dto the DTO to delete
     * @param userContext the user context containing current user information
     */
    public void delete(T dto, UserContext userContext) {
        entityManager.remove(dto);
    }

    /**
     * Finds a record by its primary key.
     *
     * @param pk the primary key value
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findByPK(long pk, UserContext userContext) {
        T dto = entityManager.find(getDTOClass(), pk);
        return dto;
    }

    /**
     * Finds a record by a unique key attribute.
     *
     * @param attribute the name of the unique attribute
     * @param val the value of the unique attribute
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext) {
        Class<T> dtoClass = getDTOClass();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(dtoClass);
        Root<T> qRoot = cq.from(dtoClass);
        Predicate condition = builder.equal(qRoot.get(attribute), val);
        cq.where(condition);
        TypedQuery<T> query = entityManager.createQuery(cq);
        List<T> list = query.getResultList();
        T dto = null;
        if (list.size() > 0) {
            dto = list.get(0);
        }
        return dto;
    }

    /**
     * Creates a typed query with criteria based on the provided DTO.
     *
     * @param dto the DTO containing search criteria
     * @param userContext the user context containing current user information
     * @return TypedQuery instance for execution
     */
    protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
        Root<T> qRoot = cq.from(getDTOClass());
        cq.select(qRoot);
        List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);
        cq.where(whereClause.toArray(new Predicate[whereClause.size()]));
        TypedQuery<T> query = entityManager.createQuery(cq);
        return query;
    }

    /**
     * Searches for records based on the provided DTO criteria with pagination.
     *
     * @param dto the DTO containing search criteria
     * @param pageNo the page number for pagination
     * @param pageSize the number of records per page
     * @param userContext the user context containing current user information
     * @return list of matching DTOs
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
        TypedQuery<T> query = createCriteria(dto, userContext);
        if (pageSize > 0) {
            query.setFirstResult(pageNo * pageSize);
            query.setMaxResults(pageSize);
        }
        List list = query.getResultList();
        return list;
    }

    /**
     * Searches for all records based on the provided DTO criteria without pagination.
     *
     * @param dto the DTO containing search criteria
     * @param userContext the user context containing current user information
     * @return list of matching DTOs
     */
    public List search(T dto, UserContext userContext) {
        return search(dto, 0, 0, userContext);
    }

    /**
     * Checks if a string is null or empty after trimming.
     *
     * @param val the string to check
     * @return true if the string is null or empty, false otherwise
     */
    protected boolean isEmptyString(String val) {
        return val == null || val.trim().length() == 0;
    }

    /**
     * Checks if a Double value is null or zero.
     *
     * @param val the Double value to check
     * @return true if the value is null or zero, false otherwise
     */
    protected boolean isZeroNumber(Double val) {
        return val == null || val == 0;
    }

    /**
     * Checks if a Long value is null or zero.
     *
     * @param val the Long value to check
     * @return true if the value is null or zero, false otherwise
     */
    protected boolean isZeroNumber(Long val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an Integer value is null or zero.
     *
     * @param val the Integer value to check
     * @return true if the value is null or zero, false otherwise
     */
    protected boolean isZeroNumber(Integer val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an object is not null.
     *
     * @param val the object to check
     * @return true if the object is not null, false otherwise
     */
    protected boolean isNotNull(Object val) {
        return val != null;
    }

    /**
     * Executes a custom HQL query to get the merit list with top 10 records.
     *
     * @param hql the HQL query to execute
     * @param userContext the user context containing current user information
     * @return list of results from the query
     */
    public List marksheetMeritList(String hql, UserContext userContext) {
        Query q = entityManager.createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(10);
        List l = q.getResultList();
        return l;
    }

}