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
import com.rays.dto.EventDTO;
import com.rays.dto.RoleDTO;
import com.rays.form.EventForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.CollegeServiceInt;
import com.rays.service.EventServiceInt;

@RestController
@RequestMapping(value = "Event")
public class EventCtl extends BaseCtl<EventForm, EventDTO, EventServiceInt> {
	@Autowired
	CollegeServiceInt collegeService;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		CollegeDTO dto = new CollegeDTO();
		// dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> list = collegeService.search(dto, userContext);
		res.addResult("collegeList", list);
		return res;
	}
}
