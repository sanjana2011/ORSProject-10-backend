package com.rays.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_event")
public class EventDTO extends BaseDTO {  

	@Column(name = "event_name", length = 50)
	private String eventName;

	@Column(name = "event_date")
	private Date eventDate;

	@Column(name = "event_type", length = 50)
	private String eventType;

	@Column(name = "college_name", length = 50)
	private String collegeName;

	@Column(name = "college_id")
	private Long collegeId;

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

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public String getUniqueKey() {
		return "eventName";
	}

	@Override
	public String getUniqueValue() {
		return eventName;
	}

	@Override
	public String getLabel() {
		return "Event Name";
	}

	@Override
	public String getTableName() {
		return "Event";
	}
  
	@Override
	public String getValue() {
		return collegeName;
	}
}
    
     
