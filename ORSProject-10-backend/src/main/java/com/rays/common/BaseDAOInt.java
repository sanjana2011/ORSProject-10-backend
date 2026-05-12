package com.rays.common;

import java.util.List;

/**
 * Base Data Access Object interface that defines standard CRUD operations
 * and search functionality for all entities.
 * This interface provides a contract for DAO implementations to perform
 * database operations on DTO objects.
 *
 * @param <T> the DTO type that extends {@link BaseDTO}
 * @author sanjana gangrade
 */
public interface BaseDAOInt<T extends BaseDTO> {

    /**
     * Adds a new record to the database.
     *
     * @param dto the DTO to add
     * @param userContext the user context containing current user information
     * @return the ID of the newly added record
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing record in the database.
     *
     * @param dto the DTO to update
     * @param userContext the user context containing current user information
     */
    public void update(T dto, UserContext userContext);

    /**
     * Deletes a record from the database.
     *
     * @param dto the DTO to delete
     * @param userContext the user context containing current user information
     */
    public void delete(T dto, UserContext userContext);

    /**
     * Finds a record by its primary key.
     *
     * @param pk the primary key value
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findByPK(long pk, UserContext userContext);

    /**
     * Finds a record by a unique key attribute.
     *
     * @param attribute the name of the unique attribute
     * @param val the value of the unique attribute
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext);

    /**
     * Searches for records based on the provided DTO criteria with pagination.
     *
     * @param dto the DTO containing search criteria
     * @param pageNo the page number for pagination
     * @param pageSize the number of records per page
     * @param userContext the user context containing current user information
     * @return list of matching DTOs
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches for all records based on the provided DTO criteria without pagination.
     *
     * @param dto the DTO containing search criteria
     * @param userContext the user context containing current user information
     * @return list of matching DTOs
     */
    public List search(T dto, UserContext userContext);

}