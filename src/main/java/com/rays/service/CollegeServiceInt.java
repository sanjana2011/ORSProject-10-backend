package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.CollegeDTO;

/**
 * CollegeServiceInt is the service interface for the College entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on CollegeDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add college-specific business
 * logic such as validating unique college names or retrieving colleges
 * by city or state if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface CollegeServiceInt extends BaseServiceInt<CollegeDTO> {

}