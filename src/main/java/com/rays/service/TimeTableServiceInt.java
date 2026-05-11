package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableServiceInt is the service interface for the TimeTable entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on TimeTableDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add timetable-specific business
 * logic such as validating schedule conflicts, retrieving timetables
 * by course or subject, or managing exam dates if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface TimeTableServiceInt extends BaseServiceInt<TimeTableDTO> {

}