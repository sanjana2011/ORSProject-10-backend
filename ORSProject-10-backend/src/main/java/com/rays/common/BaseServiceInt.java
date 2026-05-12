package com.rays.common;

import java.util.List;

/**
 * Base Service Interface that defines standard business operations
 * for all services in the application.
 * This interface provides a contract for service layer implementations
 * to perform CRUD operations and search functionality on DTO objects.
 *
 * @param <T> the DTO type that extends {@link BaseDTO}
 * @author sanjana gangrade
 */
public interface BaseServiceInt<T extends BaseDTO> {

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
     * Saves a record by either adding a new record or updating an existing one.
     *
     * @param dto the DTO to save
     * @param userContext the user context containing current user information
     * @return the ID of the saved record
     */
    public long save(T dto, UserContext userContext);

    /**
     * Deletes a record by its primary key.
     *
     * @param id the primary key value of the record to delete
     * @param userContext the user context containing current user information
     * @return the deleted DTO
     */
    public T delete(long id, UserContext userContext);

    /**
     * Finds a record by its primary key.
     *
     * @param id the primary key value
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findById(long id, UserContext userContext);

    /**
     * Finds a record by a unique key attribute.
     *
     * @param attribute the name of the unique attribute
     * @param val the value of the unique attribute
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    public T findByUniqueKey(String attribute, String val, UserContext userContext);

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