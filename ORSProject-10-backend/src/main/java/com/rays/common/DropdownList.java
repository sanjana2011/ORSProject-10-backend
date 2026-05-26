package com.rays.common;

/**
 * Dropdown List Interface that provides a contract for objects that can be
 * displayed as options in dropdown lists.
 * 
 * <p>Classes implementing this interface are expected to provide key-value pairs
 * where the key is typically the unique identifier and the value is the display
 * text shown to the user in dropdown menus.</p>
 *
 * @author sanjana gangrade
 */
public interface DropdownList {

    /**
     * Gets the key value for the dropdown option.
     * This is typically the unique identifier (e.g., ID) of the option.
     *
     * @return the key as a string
     */
    public String getKey();

    /**
     * Gets the display value for the dropdown option.
     * This is the text that will be shown to the user in the dropdown list.
     *
     * @return the display value as a string
     */
    public String getValue();

}