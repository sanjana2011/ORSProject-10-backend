package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;

/**
 * StudentServiceImpl is the service implementation class for the Student entity.
 * This class extends {@link BaseServiceImpl} and implements {@link StudentServiceInt}
 * to provide business operations for StudentDTO objects.
 * 
 * <p>This service handles student-related business logic such as managing
 * student details, search operations, and validation. It inherits standard
 * CRUD and search operations from BaseServiceImpl and can be extended to add
 * student-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<StudentDTO, StudentDAOInt> implements StudentServiceInt {

}