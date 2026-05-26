package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ContactDAOInt;
import com.rays.dto.ContactDTO;

/**
 * ContactServiceImpl is the service implementation class for the Contact entity.
 * This class extends {@link BaseServiceImpl} and implements {@link ContactServiceInt}
 * to provide business operations for ContactDTO objects.
 * 
 * <p>This service handles contact inquiry-related business logic such as
 * managing contact messages, search operations, and validation. It inherits
 * standard CRUD and search operations from BaseServiceImpl and can be extended
 * to add contact-specific business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class ContactServiceImpl extends BaseServiceImpl<ContactDTO, ContactDAOInt> implements ContactServiceInt {

}