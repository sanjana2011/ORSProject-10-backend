package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.SubjectForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * SubjectCtl is the controller class for managing subject-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Subject entity and
 * provides a preload endpoint to fetch the list of courses for
 * dropdown selections.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Subject")
public class SubjectCtl extends BaseCtl<SubjectForm, SubjectDTO, SubjectServiceInt> {
    
    /** Service for managing course-related operations. */
    @Autowired
    private CourseServiceInt courseService;
    
    /**
     * Preloads the list of courses for the subject form.
     * This method fetches all courses to populate dropdown selections
     * when creating or editing subject records.
     *
     * @return ORSResponse containing the courseList
     */
    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<DropdownList> list = courseService.search(new CourseDTO(), userContext);
        res.addResult("courseList", list);
        return res;
    }

}