package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableDAOInt is the Data Access Object interface for the TimeTable entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on TimeTableDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add timetable-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface TimeTableDAOInt extends BaseDAOInt<TimeTableDTO> {

}