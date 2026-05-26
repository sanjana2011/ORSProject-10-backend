package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.ContactDTO;

/**
 * ContactDAOInt is the Data Access Object interface for the Contact entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on ContactDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add contact-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface ContactDAOInt extends BaseDAOInt<ContactDTO> {

}