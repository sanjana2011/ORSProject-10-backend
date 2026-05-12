package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOInt is the Data Access Object interface for the Course entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on CourseDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add course-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface CourseDAOInt extends BaseDAOInt<CourseDTO> {

}