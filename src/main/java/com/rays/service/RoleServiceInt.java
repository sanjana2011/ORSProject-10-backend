package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;

/**
 * RoleServiceInt is the service interface for the Role entity.
 * This interface extends {@link BaseServiceInt} and defines the contract for
 * performing business operations on RoleDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseServiceInt and adds role-specific business logic for finding
 * a role by its name.</p>
 *
 * @author sanjana gangrade
 */
public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {

    /**
     * Finds a role by its name.
     *
     * @param name the name of the role to find
     * @param userContext the user context containing current user information
     * @return the RoleDTO if found, or null if no role exists with the given name
     */
    public RoleDTO findByName(String name, UserContext userContext);

}