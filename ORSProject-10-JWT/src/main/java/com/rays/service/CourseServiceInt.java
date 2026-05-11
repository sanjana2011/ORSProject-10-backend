package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.CourseDTO;

/**
 * CourseServiceInt is the service interface for the Course entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on CourseDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add course-specific business
 * logic such as validating unique course names or retrieving courses
 * by duration if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface CourseServiceInt extends BaseServiceInt<CourseDTO> {

}