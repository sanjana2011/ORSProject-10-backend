package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.CollegeDTO;

/**
 * CollegeDAOInt is the Data Access Object interface for the College entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on CollegeDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add college-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface CollegeDAOInt extends BaseDAOInt<CollegeDTO> {

}