package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.UserDTO;

/**
 * UserDAOInt is the Data Access Object interface for the User entity.
 * This interface extends {@link BaseDAOInt} and defines the contract for
 * performing database operations on UserDTO objects.
 * 
 * <p>This interface inherits standard CRUD and search operations from
 * BaseDAOInt and can be extended to add user-specific database
 * operations such as authentication, password management, or
 * user profile management if needed.</p>
 *
 * @author sanjana gangrade
 */
public interface UserDAOInt extends BaseDAOInt<UserDTO> {

}