package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * AttachmentDTO is the Data Transfer Object class for managing file attachments.
 * This class extends {@link BaseDTO} and represents file attachments such as
 * profile pictures, documents, or other uploaded files in the system.
 * 
 * <p>This DTO stores file metadata including name, type, description,
 * associated user ID, and the actual binary file content.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

    /** The name of the attached file. */
    @Column(name = "NAME", length = 100)
    protected String name = null;

    /** The MIME type of the attached file. */
    @Column(name = "TYPE", length = 100)
    protected String type = null;

    /** The description of the attached file. */
    @Column(name = "DESCRIPTION", length = 500)
    protected String description = null;

    /** The ID of the user associated with this attachment. */
    @Column(name = "USER_ID")
    protected Long userId = null;

    /** The binary content of the attached file. */
    @Lob
    @Column(name = "DOC")
    private byte[] doc;

    /**
     * Default constructor.
     */
    public AttachmentDTO() {
    }

    /**
     * Constructs an AttachmentDTO from a MultipartFile.
     * Extracts file name, content type, and binary data from the uploaded file.
     *
     * @param file the MultipartFile to convert to AttachmentDTO
     */
    public AttachmentDTO(MultipartFile file) {
        name = file.getOriginalFilename();
        type = file.getContentType();

        try {
            doc = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the name of the attached file.
     *
     * @return the file name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the attached file.
     *
     * @param name the file name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the MIME type of the attached file.
     *
     * @return the file type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the MIME type of the attached file.
     *
     * @param type the file type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the description of the attached file.
     *
     * @return the file description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the attached file.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the user ID associated with this attachment.
     *
     * @return the user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID associated with this attachment.
     *
     * @param userId the user ID to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the value for dropdown display.
     * This implementation returns null as attachments are not typically
     * displayed in dropdowns.
     *
     * @return null
     */
    public String getValue() {
        return null;
    }

    /**
     * Gets the binary content of the attached file.
     *
     * @return the byte array containing file data
     */
    public byte[] getDoc() {
        return doc;
    }

    /**
     * Sets the binary content of the attached file.
     *
     * @param doc the byte array containing file data to set
     */
    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    /**
     * Gets the unique key attribute name for this DTO.
     * This implementation returns null as attachments don't have a unique key.
     *
     * @return null
     */
    @Override
    public String getUniqueKey() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     * This implementation returns null as attachments don't have a unique key.
     *
     * @return null
     */
    @Override
    public String getUniqueValue() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the display label for this DTO.
     * This implementation returns null as attachments don't have a label.
     *
     * @return null
     */
    @Override
    public String getLabel() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the table name associated with this DTO.
     * This implementation returns null as attachments use a different naming.
     *
     * @return null
     */
    @Override
    public String getTableName() {
        // TODO Auto-generated method stub
        return null;
    }
}