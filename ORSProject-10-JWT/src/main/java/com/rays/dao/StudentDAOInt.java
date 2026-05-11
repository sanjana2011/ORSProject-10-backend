package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.StudentDTO;

/**
 * StudentDAOInt is the Data Access Object interface for the Student entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on StudentDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add student-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface StudentDAOInt extends BaseDAOInt<StudentDTO> {

}