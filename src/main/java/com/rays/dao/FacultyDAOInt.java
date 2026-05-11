package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyDAOInt is the Data Access Object interface for the Faculty entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on FacultyDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add faculty-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface FacultyDAOInt extends BaseDAOInt<FacultyDTO> {

}