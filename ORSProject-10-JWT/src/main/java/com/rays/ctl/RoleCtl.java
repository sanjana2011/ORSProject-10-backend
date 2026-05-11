package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * RoleCtl is the controller class for managing role-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Role entity and
 * provides a preload endpoint to fetch the list of active roles
 * for dropdown selections.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {
    
    /**
     * Preloads the list of roles for dropdown selection.
     * This method fetches all roles to populate the role dropdown
     * in the user interface.
     *
     * @return ORSResponse containing the roleList
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        RoleDTO dto = new RoleDTO();
        //dto.setStatus(RoleDTO.ACTIVE);
        List<DropdownList> list = baseService.search(dto, userContext);
        res.addResult("roleList", list);
        return res;
    }

}