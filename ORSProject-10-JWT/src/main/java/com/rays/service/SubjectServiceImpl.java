package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SubjectDAOInt;
import com.rays.dto.SubjectDTO;

/**
 * SubjectServiceImpl is the service implementation class for the Subject entity.
 * This class extends {@link BaseServiceImpl} and implements {@link SubjectServiceInt}
 * to provide business operations for SubjectDTO objects.
 * 
 * <p>This service handles subject-related business logic such as managing
 * subject details, search operations, and validation. It inherits standard
 * CRUD and search operations from BaseServiceImpl and can be extended to add
 * subject-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDTO, SubjectDAOInt> implements SubjectServiceInt {

}