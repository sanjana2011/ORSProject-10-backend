package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * MarksheetCtl is the controller class for managing marksheet-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Marksheet entity and
 * provides additional endpoints for preloading student data, finding
 * marksheets by roll number, and retrieving the merit list.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {
    
    /** Service for managing student-related operations. */
    @Autowired
    private StudentServiceInt studentService;

    /**
     * Preloads the list of students for the marksheet form.
     * This method fetches all students to populate dropdown selections
     * when creating or editing marksheets.
     *
     * @return ORSResponse containing the studentList
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<StudentDTO> list = studentService.search(new StudentDTO(), userContext);
        res.addResult("studentList", list);
        return res;
    }
    
    /**
     * Finds a marksheet by its roll number.
     *
     * @param rollNo the roll number to search for
     * @return ORSResponse containing the marksheet details if found,
     *         or an error message if not found
     */
    @GetMapping("rollno/{rollNo}")
    public ORSResponse rollNo(@PathVariable String rollNo) {
        ORSResponse res = new ORSResponse(true);
        MarksheetDTO dto = baseService.findByRollNo(rollNo, userContext);
        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        return res;
    }

    /**
     * Retrieves the merit list of students based on their marks.
     * This method returns a list of top-performing students sorted
     * by their total marks or percentage.
     *
     * @return ORSResponse containing the merit list
     */
    @GetMapping("meritlist")
    public ORSResponse getMeritList() {
        System.out.println("getMeritList run on ctl");
        List<MarksheetDTO> list = baseService.getMeritList(userContext);
        ORSResponse res = new ORSResponse(true);
        res.addResult("list",list);
        // System.out.println("Merit list :: " + list);
        return res;
    }

}