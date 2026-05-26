package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FacultyDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyServiceImpl is the service implementation class for the Faculty entity.
 * This class extends {@link BaseServiceImpl} and implements {@link FacultyServiceInt}
 * to provide business operations for FacultyDTO objects.
 * 
 * <p>This service handles faculty-related business logic such as managing
 * faculty details, search operations, and validation. It inherits standard
 * CRUD and search operations from BaseServiceImpl and can be extended to add
 * faculty-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class FacultyServiceImpl extends BaseServiceImpl<FacultyDTO, FacultyDAOInt> implements FacultyServiceInt {

}