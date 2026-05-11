package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentServiceImpl is the service implementation class for the Attachment entity.
 * This class extends {@link BaseServiceImpl} and implements {@link AttachmentServiceInt}
 * to provide business operations for AttachmentDTO objects.
 * 
 * <p>This service handles file attachment operations such as uploading profile pictures,
 * documents, and other file attachments. It inherits standard CRUD and search
 * operations from BaseServiceImpl and can be extended to add attachment-specific
 * business logic if needed.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentDTO, AttachmentDAOInt>
        implements AttachmentServiceInt {

}