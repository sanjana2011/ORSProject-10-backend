package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyServiceInt is the service interface for the Faculty entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on FacultyDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add faculty-specific business
 * logic such as validating unique email addresses, retrieving faculty
 * by college or subject, or managing faculty assignments if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface FacultyServiceInt extends BaseServiceInt<FacultyDTO> {

}