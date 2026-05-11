package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.StudentDTO;

/**
 * StudentServiceInt is the service interface for the Student entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on StudentDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add student-specific business
 * logic such as validating unique enrollment numbers, retrieving students
 * by college, or managing student registration if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface StudentServiceInt extends BaseServiceInt<StudentDTO> {

}