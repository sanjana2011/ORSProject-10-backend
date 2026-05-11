package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.FacultyForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.FacultyServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * FacultyCtl is the controller class for managing faculty-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Faculty entity and
 * delegates business logic to the FacultyServiceInt service layer.
 * It also provides a preload endpoint to fetch dropdown lists for
 * courses, subjects, and colleges.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Faculty")
public class FacultyCtl extends BaseCtl<FacultyForm, FacultyDTO, FacultyServiceInt> {

    /** Service for managing course-related operations. */
    @Autowired
    private CourseServiceInt courseService;

    /** Service for managing subject-related operations. */
    @Autowired
    private SubjectServiceInt subjectService;

    /** Service for managing college-related operations. */
    @Autowired
    private CollegeServiceInt collegeService;

    /**
     * Preloads dropdown lists required for the faculty form.
     * This method fetches lists of courses, subjects, and colleges
     * to populate dropdown selections in the user interface.
     *
     * @return ORSResponse containing courseList, subjectList, and collegeList
     */
    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<DropdownList> courseList = courseService.search(new CourseDTO(), userContext);
        List<DropdownList> subjectList = subjectService.search(new SubjectDTO(), userContext);
        List<DropdownList> collegeList = collegeService.search(new CollegeDTO(), userContext);
        res.addResult("courseList", courseList);
        res.addResult("subjectList", subjectList);
        res.addResult("collegeList", collegeList);
        return res;
    }

}