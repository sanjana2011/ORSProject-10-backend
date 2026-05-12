package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;

/**
 * Base Controller class that provides common CRUD operations for all controllers.
 * This class serves as a generic controller with support for save, get, delete,
 * and search operations.
 *
 * @param <F> the form type that extends {@link BaseForm}
 * @param <T> the DTO type that extends {@link BaseDTO}
 * @param <S> the service type that extends {@link BaseServiceInt}
 * @author sanjana gangrade
 */
public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

    /** The base service instance for performing database operations. */
    @Autowired
    protected S baseService;

    /** The page size for pagination, configured from application properties. */
    @Value("${page.size}")
    private int pageSize = 0;

    /** The user context containing current user information. */
    protected UserContext userContext = null;

    /**
     * Sets the user context for the current request.
     * Retrieves user context from {@link UserContextHolder} and sets a default
     * user if context is not available.
     */
    @ModelAttribute
    public void setUserContext() {
        userContext = UserContextHolder.getContext();
        if (userContext == null) {
            UserDTO dto = new UserDTO();
            dto.setLoginId("sanjana@gmail.com");
            userContext = new UserContext(dto);
        }
    }

    /**
     * Validates the binding result and returns validation errors if any.
     *
     * @param bindingResult the binding result containing validation errors
     * @return ORSResponse containing validation status and errors if present
     */
    public ORSResponse validate(BindingResult bindingResult) {

        ORSResponse res = new ORSResponse(true);

        if (bindingResult.hasErrors()) {

            res.setSuccess(false);

            Map<String, String> errors = new HashMap<String, String>();

            List<FieldError> list = bindingResult.getFieldErrors();
            list.forEach(e -> {
                errors.put(e.getField(), e.getDefaultMessage());
            });
            res.addInputError(errors);
        }
        return res;
    }

    /**
     * Saves or updates a record.
     * Performs validation, checks for uniqueness, and either adds a new record
     * or updates an existing one.
     *
     * @param form the form containing the data to be saved
     * @param bindingResult the binding result for validation
     * @return ORSResponse containing the operation status and result
     */
    @PostMapping("/save")
    public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (res.isSuccess() == false) {
            return res;
        }

        T dto = (T) form.getDto();

        if (dto.getId() != null && dto.getId() > 0) {
            T existDto1 = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
            if (existDto1 != null && dto.getId() != existDto1.getId()) {
                res.setSuccess(false);
                res.addMessage(dto.getLabel() + " already exist");
                return res;
            }
            baseService.update(dto, userContext);
            res.addData(dto.getId());
            res.addMessage(dto.getTableName() + " updated successfully..!!");
        } else {
            if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {
                T existDto = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
                if (existDto != null) {
                    res.setSuccess(false);
                    res.addMessage(dto.getLabel() + " already exist");
                    return res;
                }
            }
            baseService.add(dto, userContext);
            res.addMessage(dto.getTableName() + " added successfully..!!");
        }
        return res;
    }

    /**
     * Retrieves a record by its ID.
     *
     * @param id the ID of the record to retrieve
     * @return ORSResponse containing the found record or an error message if not found
     */
    @GetMapping("get/{id}")
    public ORSResponse get(@PathVariable long id) {
        ORSResponse res = new ORSResponse(true);
        T dto = baseService.findById(id, userContext);
        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        return res;
    }

    /**
     * Deletes multiple records by their IDs.
     *
     * @param ids array of IDs to delete
     * @param pageNo the current page number for pagination
     * @param form the form containing search criteria for updated list
     * @return ORSResponse containing the updated list and operation status
     */
    @PostMapping("deleteMany/{ids}")
    public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo,
            @RequestBody F form) {

        ORSResponse res = new ORSResponse(true);
        for (String id : ids) {
            baseService.delete(Long.parseLong(id), userContext);
        }

        T dto = (T) form.getDto();

        List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);

        List<T> nextList = baseService.search(dto, Integer.parseInt(pageNo + 1), pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addMessage("Records Deleted Successfully");
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }
        return res;
    }

    /**
     * Searches for records based on the provided criteria with pagination.
     *
     * @param form the form containing search criteria
     * @param pageNo the page number for pagination
     * @return ORSResponse containing the search results and next page size
     */
    @RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
    public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {

        pageNo = (pageNo < 0) ? 0 : pageNo;

        T dto = (T) form.getDto();

        ORSResponse res = new ORSResponse(true);

        List<T> list = baseService.search(dto, pageNo, pageSize, userContext);

        List<T> nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);

        if (list.size() == 0) {
            res.setSuccess(false);
            res.addMessage("Record not found..!!");
        } else {
            res.setSuccess(true);
            res.addData(list);
            res.addResult("nextListSize", nextList.size());
        }
        return res;
    }
}