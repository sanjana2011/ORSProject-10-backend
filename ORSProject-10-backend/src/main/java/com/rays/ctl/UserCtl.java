package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

/**
 * UserCtl is the controller class for managing user-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the User entity and provides
 * additional endpoints for preloading roles, updating user profile,
 * changing password, and managing profile pictures.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

    /** Service for managing role-related operations. */
    @Autowired
    RoleServiceInt roleService = null;

    /** Service for managing attachment-related operations (profile pictures). */
    @Autowired
    AttachmentServiceInt attachmentService;

    /**
     * Preloads the list of roles for the user form.
     * This method fetches all roles to populate dropdown selections
     * when creating or editing user records.
     *
     * @return ORSResponse containing the roleList
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        RoleDTO dto = new RoleDTO();
        // dto.setStatus(RoleDTO.ACTIVE);
        List<DropdownList> list = roleService.search(dto, userContext);
        res.addResult("roleList", list);
        return res;
    }

    /**
     * Updates the profile information of the currently logged-in user.
     *
     * @param form the my profile form containing updated user details
     * @param bindingResult the binding result for validation
     * @return ORSResponse containing success status and message
     */
    @PostMapping("myProfile")
    public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }
        System.out.println(userContext.getUserId());
        UserDTO dto = baseService.findByLoginId(userContext.getLoginId(), userContext);
        
        dto.setFirstName(form.getFirstName());
        dto.setLastName(form.getLastName());
        dto.setDob(form.getDob());
        dto.setPhone(form.getPhone());
        dto.setGender(form.getGender());

        baseService.update(dto, userContext);

        res.setSuccess(true);
        res.addMessage("Your Profile updated successfully..!!");

        return res;
    }

    /**
     * Changes the password for a user after validating the old password.
     *
     * @param form the change password form containing login ID, old password, and new password
     * @param bindingResult the binding result for validation
     * @return ORSResponse containing success status and message,
     *         or an error if the old password is invalid
     */
    @PostMapping("changePassword")
    public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO changedDto = baseService.changePassword(form.getLoginId(), form.getOldPassword(), form.getNewPassword(),
                userContext);

        if (changedDto == null) {
            res.setSuccess(false);
            res.addMessage("Invalid old password");
            return res;
        }

        res.setSuccess(true);
        res.addMessage("Password has been changed");

        return res;
    }

    /**
     * Uploads a profile picture for a user.
     * If the user already has a profile picture, it updates the existing one.
     *
     * @param userId the ID of the user
     * @param file the multipart file to upload as profile picture
     * @param req the HTTP servlet request
     * @return ORSResponse containing the image ID of the uploaded picture
     */
    @PostMapping("/profilePic/{userId}")
    public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
            HttpServletRequest req) {

        AttachmentDTO attachmentDto = new AttachmentDTO(file);

        attachmentDto.setDescription("profile pic");

        attachmentDto.setUserId(userId);

        UserDTO userDto = baseService.findById(userId, userContext);

        if (userDto.getImageId() != null && userDto.getImageId() > 0) {

            attachmentDto.setId(userDto.getImageId());

        }

        Long imageId = attachmentService.save(attachmentDto, userContext);

        if (userDto.getImageId() == null) {

            userDto.setImageId(imageId);

            baseService.update(userDto, null);
        }

        ORSResponse res = new ORSResponse();

        res.addResult("imageId", imageId);

        return res;
    }

    /**
     * Downloads the profile picture of a user.
     *
     * @param userId the ID of the user whose profile picture to download
     * @param response the HTTP servlet response to write the image data
     */
    @GetMapping("/profilePic/{userId}")
    public void downloadPic(@PathVariable Long userId, HttpServletResponse response) {

        try {

            UserDTO userDto = baseService.findById(userId, userContext);

            AttachmentDTO attachmentDTO = null;

            if (userDto != null) {
                attachmentDTO = attachmentService.findById(userDto.getImageId(), null);
            }

            if (attachmentDTO != null) {
                response.setContentType(attachmentDTO.getType());
                OutputStream out = response.getOutputStream();
                out.write(attachmentDTO.getDoc());
                out.close();
            } else {
                response.getWriter().write("ERROR: File not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}