package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.SubjectDTO;

/**
 * SubjectServiceInt is the service interface for the Subject entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on SubjectDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add subject-specific business
 * logic such as validating unique subject names within a course,
 * retrieving subjects by course, or managing subject assignments
 * to faculty members if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface SubjectServiceInt extends BaseServiceInt<SubjectDTO> {

}