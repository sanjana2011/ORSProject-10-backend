package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

/**
 * TimeTableCtl is the controller class for managing timetable-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the TimeTable entity and
 * provides a preload endpoint to fetch the lists of courses and subjects
 * for dropdown selections.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDTO, TimeTableServiceInt> {
    
    /** Service for managing course-related operations. */
    @Autowired
    private CourseServiceInt courseService;
    
    /** Service for managing subject-related operations. */
    @Autowired
    private SubjectServiceInt subjectService;
    
    /**
     * Preloads the lists of courses and subjects for the timetable form.
     * This method fetches all courses and subjects to populate dropdown
     * selections when creating or editing timetable records.
     *
     * @return ORSResponse containing courseList and subjectList
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<CourseDTO> list = courseService.search(new CourseDTO(), userContext);
        List<SubjectDTO> list1 = subjectService.search(new SubjectDTO(), userContext);
        res.addResult("courseList", list);
        res.addResult("subjectList", list1);
        return res;
    }

}