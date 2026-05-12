package com.rays.common;

/**
 * Base Form class that serves as a superclass for all form objects in the application.
 * This class holds common fields and provides utility methods for form to DTO conversion.
 * Forms are used to capture and validate user input from the presentation layer.
 *
 * @author sanjana gangrade
 */
public class BaseForm {

    /** The primary key identifier for the form. */
    protected Long id;

    /** The login ID of the user who created the record. */
    protected String createdBy;

    /** The login ID of the user who last modified the record. */
    protected String modifiedBy;

    /** The creation timestamp of the record (in milliseconds). */
    protected long createdDatetime;

    /** The last modification timestamp of the record (in milliseconds). */
    protected long modifiedDatetime;

    /** Array of IDs for bulk operations. */
    private Long[] ids;

    /** The current page number for pagination. Default value is 0. */
    private int pageNo = 0;

    /** The number of records per page for pagination. Default value is 5. */
    private int pageSize = 5;

    /** The operation to be performed (e.g., save, update, delete). */
    private String operation;

    /**
     * Gets the ID of the form.
     *
     * @return the primary key ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the form.
     *
     * @param id the primary key ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Converts the form to a DTO object.
     * This method should be overridden by subclasses to provide proper conversion logic.
     *
     * @return the DTO object, or null if not implemented
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Initializes a DTO with the form data.
     * Sets the ID from the form to the DTO.
     *
     * @param <T> the DTO type that extends {@link BaseDTO}
     * @param dto the DTO to initialize
     * @return the initialized DTO with ID set from the form
     */
    public <T extends BaseDTO> T initDTO(T dto) {
        System.out.println("id => base dto => " + id);
        if (id != null && id > 0) {
            dto.setId(id);
        } else {
            dto.setId(null);
        }
        return dto;
    
        
    }
}