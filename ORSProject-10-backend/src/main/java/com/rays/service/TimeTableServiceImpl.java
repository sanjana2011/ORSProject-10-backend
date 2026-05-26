package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TimeTableDAOInt;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableServiceImpl is the service implementation class for the TimeTable entity.
 * This class extends {@link BaseServiceImpl} and implements {@link TimeTableServiceInt}
 * to provide business operations for TimeTableDTO objects.
 * 
 * <p>This service handles timetable-related business logic such as managing
 * exam schedules, class timetables, search operations, and validation. It inherits
 * standard CRUD and search operations from BaseServiceImpl and can be extended
 * to add timetable-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class TimeTableServiceImpl extends BaseServiceImpl<TimeTableDTO, TimeTableDAOInt>
        implements TimeTableServiceInt {

}