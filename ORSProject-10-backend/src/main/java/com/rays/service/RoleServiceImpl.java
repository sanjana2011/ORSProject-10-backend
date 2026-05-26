package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

/**
 * RoleServiceImpl is the service implementation class for the Role entity.
 * This class extends {@link BaseServiceImpl} and implements {@link RoleServiceInt}
 * to provide business operations for RoleDTO objects.
 * 
 * <p>This service handles role-related business logic such as managing
 * role details, search operations, and finding roles by name. It inherits
 * standard CRUD and search operations from BaseServiceImpl and adds
 * role-specific business logic.</p>
 *
 * @author sanjana gangrade
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

    /**
     * Finds a role by its name.
     *
     * @param name the name of the role to find
     * @param userContext the user context containing current user information
     * @return the RoleDTO if found, or null if no role exists with the given name
     */
    @Transactional(readOnly = true)
    public RoleDTO findByName(String name, UserContext userContext) {
        return baseDao.findByUniqueKey("name", name, userContext);
    }
}