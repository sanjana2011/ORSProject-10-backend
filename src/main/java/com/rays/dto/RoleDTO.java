package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * RoleDTO is the Data Transfer Object class for the Role entity.
 * This class extends {@link BaseDTO} and represents a user role in the system.
 * 
 * <p>This DTO stores role details including name and description. It implements
 * the required methods for unique key identification using role name and
 * dropdown display.</p>
 *
 * @author sanjana gangrade
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

    /** The name of the role (e.g., ADMIN, USER, FACULTY). */
    @Column(name = "name", length = 50)
    private String name = null;

    /** The description of the role. */
    @Column(name = "description", length = 100)
    private String description = null;

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
     * Gets the unique key attribute name for this DTO.
     * The role name serves as the unique key.
     *
     * @return "name" as the unique key attribute
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Gets the value of the unique key attribute for this DTO.
     *
     * @return the role name as the unique value
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Gets the display label for this DTO.
     *
     * @return "Role Name" as the display label
     */
    @Override
    public String getLabel() {
        return "Role Name";
    }
    
    /**
     * Gets the table name associated with this DTO.
     *
     * @return "Role" as the table name
     */
    @Override
    public String getTableName() {
        return "Role";
    }

    /**
     * Gets the value for dropdown display.
     *
     * @return the role name
     */
    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return name;
    }
}