package com.rays.dao;

import java.util.List;

import com.rays.common.BaseDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetDAOInt is the Data Access Object interface for the Marksheet entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on MarksheetDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and adds marksheet-specific operations such as retrieving
 * the merit list of top-performing students.</p>
 *
 * @author sanjana gangrade
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {

    /**
     * Retrieves the merit list of top-performing students.
     * This method fetches marksheets sorted by total marks
     * in descending order and returns the top records.
     *
     * @return list of MarksheetDTO objects representing the merit list
     */
    List<MarksheetDTO> getMeritList();

}