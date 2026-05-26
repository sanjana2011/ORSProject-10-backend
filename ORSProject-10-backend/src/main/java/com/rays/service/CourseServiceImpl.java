package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * CourseServiceImpl is the service implementation class for the Course entity.
 * This class extends {@link BaseServiceImpl} and implements {@link CourseServiceInt}
 * to provide business operations for CourseDTO objects.
 * 
 * <p>This service handles course-related business logic such as managing
 * course details, search operations, and validation. It inherits standard
 * CRUD and search operations from BaseServiceImpl and can be extended to add
 * course-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseDTO, CourseDAOInt> implements CourseServiceInt {

}