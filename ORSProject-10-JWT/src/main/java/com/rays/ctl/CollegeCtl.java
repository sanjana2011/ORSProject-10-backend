package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceInt;

/**
 * CollegeCtl is the controller class for managing college-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the College entity and
 * delegates business logic to the CollegeServiceInt service layer.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt> {

}