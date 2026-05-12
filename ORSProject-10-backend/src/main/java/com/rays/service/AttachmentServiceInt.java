package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentServiceInt is the service interface for the Attachment entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on AttachmentDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and can be extended to add attachment-specific business
 * logic such as file upload/download operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface AttachmentServiceInt extends BaseServiceInt<AttachmentDTO> {

}