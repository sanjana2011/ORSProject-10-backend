package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentDAOInt is the Data Access Object interface for the Attachment entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on AttachmentDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add attachment-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface AttachmentDAOInt extends BaseDAOInt<AttachmentDTO> {

}