package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base Data Transfer Object class that provides common fields and functionality
 * for all DTOs in the application. This class serves as a superclass for all
 * entity DTOs and implements the {@link DropdownList} interface.
 * 
 * <p>This class is annotated with {@link MappedSuperclass} to indicate that
 * it is a mapped superclass whose mapping information is applied to entities
 * that inherit from it.</p>
 *
 * @author sanjana gangrade
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

    /** The primary key identifier for the entity. */
    @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk", strategy = "native")
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    /** The login ID of the user who created the record. Default value is "root". */
    @Column(name = "created_by", length = 50)
    protected String createdBy = "root";

    /** The login ID of the user who last modified the record. Default value is "root". */
    @Column(name = "modified_by", length = 50)
    protected String modifiedBy = "root";

    /** The timestamp when the record was created. */
    @Column(name = "created_datetime")
    protected Timestamp createdDatetime;

    /** The timestamp when the record was last modified. */
    @Column(name = "modified_datetime")
    protected Timestamp modifiedDatetime;

    /**
     * Gets the unique key attribute name for this DTO.
     * Used to identify which field serves as the unique constraint.
     *
     * @return the name of the unique key attribute
     */
    public abstract String getUniqueKey();

    /**
     * Gets the value of the unique key attribute for this DTO.
     * Used to check uniqueness during save/update operations.
     *
     * @return the value of the unique key attribute
     */
    public abstract String getUniqueValue();

    /**
     * Gets the display label for this DTO.
     * Used for showing meaningful names in error messages and UI.
     *
     * @return the display label
     */
    public abstract String getLabel();
    
    /**
     * Gets the table name associated with this DTO.
     * Used for generating meaningful success messages.
     *
     * @return the table name
     */
    public abstract String getTableName();

    /**
     * Gets the ID of the record.
     *
     * @return the primary key ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the record.
     *
     * @param id the primary key ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the login ID of the user who created the record.
     *
     * @return the created by login ID
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the login ID of the user who created the record.
     *
     * @param createdBy the created by login ID to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the login ID of the user who last modified the record.
     *
     * @return the modified by login ID
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the login ID of the user who last modified the record.
     *
     * @param modifiedBy the modified by login ID to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the creation timestamp of the record.
     *
     * @return the created datetime
     */
    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     * Sets the creation timestamp of the record.
     *
     * @param createdDatetime the created datetime to set
     */
    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /**
     * Gets the last modification timestamp of the record.
     *
     * @return the modified datetime
     */
    public Timestamp getModifiedDatetime() {
        return modifiedDatetime;
    }

    /**
     * Sets the last modification timestamp of the record.
     *
     * @param modifiedDatetime the modified datetime to set
     */
    public void setModifiedDatetime(Timestamp modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }

    /**
     * Gets the key value for dropdown display.
     * Implements the {@link DropdownList#getKey()} method.
     *
     * @return the ID as a string to be used as dropdown option key
     */
    @Override
    public String getKey() {
        return String.valueOf(id);
    }
    
}