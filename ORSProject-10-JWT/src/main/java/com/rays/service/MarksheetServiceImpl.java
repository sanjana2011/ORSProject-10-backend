package com.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetServiceImpl is the service implementation class for the Marksheet entity.
 * This class extends {@link BaseServiceImpl} and implements {@link MarksheetServiceInt}
 * to provide business operations for MarksheetDTO objects.
 * 
 * <p>This service handles marksheet-related business logic such as managing
 * student marks, search operations, finding marksheets by name or roll number,
 * and retrieving the merit list of top-performing students. It inherits standard
 * CRUD and search operations from BaseServiceImpl and adds marksheet-specific
 * business logic.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt>
        implements MarksheetServiceInt {
    
    /**
     * Finds a marksheet by the student's name.
     *
     * @param name the name of the student
     * @param context the user context containing current user information
     * @return the MarksheetDTO if found, or null if no marksheet exists with the given name
     */
    @Transactional(readOnly = true)
    public MarksheetDTO findByName(String name, UserContext context) {
        return baseDao.findByUniqueKey("name", name, context);
    }

    /**
     * Finds a marksheet by the student's roll number.
     *
     * @param rollNo the roll number of the student
     * @param context the user context containing current user information
     * @return the MarksheetDTO if found, or null if no marksheet exists with the given roll number
     */
    @Override
    public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
        return baseDao.findByUniqueKey("rollNo", rollNo, context);
    }

    /**
     * Retrieves the merit list of top-performing students.
     * This method fetches marksheets sorted by total marks
     * (physics + chemistry + mathematics) in descending order.
     *
     * @param context the user context containing current user information
     * @return list of MarksheetDTO objects representing the merit list
     */
    @Override
    public List<MarksheetDTO> getMeritList(UserContext context) {
        System.out.println("getMeritList run in service");
        return baseDao.getMeritList();
    }
}