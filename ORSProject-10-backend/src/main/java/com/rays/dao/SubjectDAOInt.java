package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.SubjectDTO;

/**
 * SubjectDAOInt is the Data Access Object interface for the Subject entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on SubjectDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add subject-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface SubjectDAOInt extends BaseDAOInt<SubjectDTO> {

}