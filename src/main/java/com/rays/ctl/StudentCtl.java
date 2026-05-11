package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * StudentCtl is the controller class for managing student-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Student entity and
 * provides a preload endpoint to fetch the list of colleges for
 * dropdown selections.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentForm, StudentDTO, StudentServiceInt> {
    
    /** Service for managing college-related operations. */
    @Autowired
    private CollegeServiceInt collegeService;

    /**
     * Preloads the list of colleges for the student form.
     * This method fetches all colleges to populate dropdown selections
     * when creating or editing student records.
     *
     * @return ORSResponse containing the collegeList
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);
        res.addResult("collegeList", list);
        return res;
    }

}