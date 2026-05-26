package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Base Service Implementation class that provides common business logic
 * and transactional operations for all services in the application.
 * This class implements the {@link BaseServiceInt} interface and delegates
 * database operations to the corresponding DAO layer.
 *
 * @param <T> the DTO type that extends {@link BaseDTO}
 * @param <D> the DAO type that extends {@link BaseDAOInt}
 * @author sanjana gangrade
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

    /** The base DAO instance for performing database operations. */
    @Autowired
    protected D baseDao;

    /**
     * Adds a new record to the database.
     *
     * @param dto the DTO to add
     * @param userContext the user context containing current user information
     * @return the ID of the newly added record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(readOnly = false)
    public long add(T dto, UserContext userContext) {
        long pk = baseDao.add(dto, userContext);
        return pk;
    }

    /**
     * Updates an existing record in the database.
     * Preserves the created by and created datetime fields from the original record.
     *
     * @param dto the DTO to update
     * @param userContext the user context containing current user information
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T dto, UserContext userContext) {

        T oldDto = baseDao.findByPK(dto.getId(), userContext);

        if (oldDto != null) {
            dto.setCreatedBy(oldDto.getCreatedBy());
            dto.setCreatedDatetime(oldDto.getCreatedDatetime());
        }

        baseDao.update(dto, userContext);
    }

    /**
     * Saves a record by either adding a new record or updating an existing one.
     * If the DTO has an ID greater than 0, it performs an update; otherwise, it performs an add.
     *
     * @param dto the DTO to save
     * @param userContext the user context containing current user information
     * @return the ID of the saved record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(T dto, UserContext userContext) {
        Long id = dto.getId();
        if (id != null && id > 0) {
            update(dto, userContext);
        } else {
            id = add(dto, userContext);
        }
        return id;
    }

    /**
     * Finds a record by its primary key.
     *
     * @param id the primary key value
     * @param userContext the user context containing current user information
     * @return the found DTO, or null if not found
     */
    @Transactional(readOnly = true)
    public T findById(long id, UserContext userContext) {
        T dto = baseDao.findByPK(id, userContext);
        return dto;
    }

    /**
     * Deletes a record by its primary key.
     *
     * @param id the primary key value of the record to delete
     * @param userContext the user context containing current user information
     * @return the deleted DTO
     * @throws DatabaseException if the record is not found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public T delete(long id, UserContext userContext) {
        T dto = findById(id, userContext);
        if (dto == null) {
            
        }
        baseDao.delete(dto, userContext);
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
    @Transactional(readOnly = true)
    public T findByUniqueKey(String attribute, String val, UserContext userContext) {
        T dto = baseDao.findByUniqueKey(attribute, val, userContext);
        return dto;
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
    @Transactional(readOnly = true)
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
        return baseDao.search(dto, pageNo, pageSize, userContext);
    }

    /**
     * Searches for all records based on the provided DTO criteria without pagination.
     *
     * @param dto the DTO containing search criteria
     * @param userContext the user context containing current user information
     * @return list of matching DTOs
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, UserContext userContext) {
        return baseDao.search(dto, userContext);
    }
}