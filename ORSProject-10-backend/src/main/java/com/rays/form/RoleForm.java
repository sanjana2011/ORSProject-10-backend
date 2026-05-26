package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

/**
 * RoleForm is a form class used for capturing role-related data.
 * This class extends {@link BaseForm} and contains fields for role details
 * with validation constraints.
 * 
 * <p>This form is used to collect and validate role information such as
 * name and description before converting it to a {@link RoleDTO} object
 * for database operations. It also defines constants for standard
 * system roles.</p>
 *
 * @author sanjana gangrade
 */
public class RoleForm extends BaseForm {

    /** Constant representing the ADMIN role ID. */
    public static final int ADMIN = 1;
    
    /** Constant representing the STUDENT role ID. */
    public static final int STUDENT = 2;
    
    /** Constant representing the FACULTY role ID. */
    public static final int FACULTY = 3;
    
    /** Constant representing the KIOSK role ID. */
    public static final int KIOSK = 4;

    /** The name of the role (e.g., ADMIN, USER, FACULTY). */
    @NotEmpty(message = "Name is required")
    private String name;

    /** The description of the role. */
    @NotEmpty(message = "Description is required")
    private String description;

    /**
     * Gets the name of the role.
     *
     * @return the role name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     *
     * @param name the role name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the role.
     *
     * @return the role description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the role.
     *
     * @param description the role description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Converts the form data to a {@link RoleDTO} object.
     * This method initializes a DTO using the parent class method and
     * populates it with form field values.
     *
     * @return the populated RoleDTO object
     */
    @Override
    public BaseDTO getDto() {
        RoleDTO dto = initDTO(new RoleDTO());
        dto.setDescription(description);
        dto.setName(name);
        return dto;
    }
}