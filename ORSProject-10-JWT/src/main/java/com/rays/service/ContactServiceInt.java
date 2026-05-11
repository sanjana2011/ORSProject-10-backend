package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.ContactDTO;

/**
 * ContactServiceInt is the service interface for the Contact entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on ContactDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add contact-specific business
 * logic such as sending email notifications for new contact inquiries
 * or retrieving contacts by email or mobile number if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface ContactServiceInt extends BaseServiceInt<ContactDTO> {

}