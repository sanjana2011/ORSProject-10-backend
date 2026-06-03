package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.EventDTO; 

@Repository
public class EventDAOImpl extends BaseDAOImpl<EventDTO> implements EventDAOInt {
	
	@Autowired
	CollegeDAOInt collegeDao;

    @Override
    public Class<EventDTO> getDTOClass() {
        return EventDTO.class;
    }

    @Override
    protected void populate(EventDTO dto, UserContext userContext) {
    	
    	System.out.println(dto.getCollegeId());
        if (dto.getCollegeId() != null && dto.getCollegeId() > 0) {
        	CollegeDTO collegedto = collegeDao.findByPK(dto.getCollegeId(), userContext);
        	dto.setCollegeName(collegedto.getName());
		}
    }

    @Override
    protected List<Predicate> getWhereClause(EventDTO dto, CriteriaBuilder builder, Root<EventDTO> qRoot) {
        List<Predicate> whereCondition = new ArrayList<Predicate>();

        if (!isEmptyString(dto.getEventName())) {
            whereCondition.add(builder.like(qRoot.get("eventName"), dto.getEventName() + "%"));
        }

        if (isNotNull(dto.getEventDate())) {
            whereCondition.add(builder.equal(qRoot.get("eventDate"), dto.getEventDate()));
        }

        if (!isEmptyString(dto.getEventType())) {
            whereCondition.add(builder.like(qRoot.get("eventType"), dto.getEventType() + "%"));
        }

        if (isNotNull(dto.getCollegeId())) {
            whereCondition.add(builder.equal(qRoot.get("collegeId"), dto.getCollegeId()));
        }

        return whereCondition;
    }
}
       
    
