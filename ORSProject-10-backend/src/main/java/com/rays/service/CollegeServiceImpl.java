package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

/**
 * CollegeServiceImpl is the service implementation class for the College entity.
 * This class extends {@link BaseServiceImpl} and implements {@link CollegeServiceInt}
 * to provide business operations for CollegeDTO objects.
 * 
 * <p>This service handles college-related business logic such as managing
 * college details, search operations, and validation. It inherits standard
 * CRUD and search operations from BaseServiceImpl and can be extended to add
 * college-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {

}