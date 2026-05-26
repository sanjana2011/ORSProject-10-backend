package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOInt is the Data Access Object interface for the Role entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on RoleDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add role-specific database
 * operations if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface RoleDAOInt extends BaseDAOInt<RoleDTO> {

}