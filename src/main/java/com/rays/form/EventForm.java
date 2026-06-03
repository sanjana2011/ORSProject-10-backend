package com.rays.form;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EventDTO; 

public class EventForm extends BaseForm {

	@NotEmpty(message = "Event Name is required")
	private String eventName;

	@NotNull(message = "Event Date is required")
	private Date eventDate;

	@NotEmpty(message = "Event Type is required")
	private String eventType;

	private String collegeName;

	@NotNull(message = "college Name is required")
	private Long collegeId;

	
	
	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public BaseDTO getDto() {
		EventDTO dto = initDTO(new EventDTO());
		dto.setEventName(eventName);
		dto.setEventDate(eventDate);
		dto.setEventType(eventType);
		dto.setCollegeName(collegeName);
		dto.setCollegeId(collegeId);
		return dto;
	}
}
                
