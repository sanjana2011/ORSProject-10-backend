package com.rays.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * LoginCtl is the controller class for handling authentication operations.
 * This class extends {@link BaseCtl} and provides endpoints for user login,
 * registration, and logout functionality.
 * 
 * <p>This controller manages user authentication using JWT tokens,
 * user registration with role assignment, and session management
 * for logout operations.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

    /** Utility class for JWT token generation. */
    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Authenticates a user and generates a JWT token upon successful login.
     *
     * @param form the login form containing login ID and password
     * @param bindingResult the binding result for validation
     * @param session the HTTP session
     * @param request the HTTP request
     * @return ORSResponse containing user details and JWT token if successful,
     *         or an error message if authentication fails
     * @throws Exception if an error occurs during token generation
     */
    @PostMapping("login")
    public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session,
            HttpServletRequest request) throws Exception {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO dto = baseService.authenticate(form.getLoginId(), form.getPassword());

        if (dto == null) {
            res.setSuccess(false);
            res.addMessage("Invalid Login ID & Password");
        } else {

            String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());

            res.setSuccess(true);
            res.addData(dto);
            res.addResult("loginId", dto.getLoginId());
            res.addResult("role", dto.getRoleName());
            res.addResult("fname", dto.getFirstName());
            res.addResult("lname", dto.getLastName());
            res.addResult("token", token);
            return res;
        }
        return res;
    }

    /**
     * Registers a new user in the system.
     * Creates a new user account with "Inactive" status and default role ID 2.
     *
     * @param form the user registration form containing user details
     * @param bindingResult the binding result for validation
     * @return ORSResponse containing success status and message,
     *         or an error if login ID already exists
     */
    @PostMapping("signUp")
    public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO dto = baseService.findByLoginId(form.getLoginId(), userContext);

        if (dto != null) {
            res.setSuccess(false);
            res.addMessage("Login Id already exists");
            return res;
        }

        dto = new UserDTO();
        dto.setFirstName(form.getFirstName());
        dto.setLastName(form.getLastName());
        dto.setLoginId(form.getLoginId());
        dto.setPassword(form.getPassword());
        dto.setDob(form.getDob());
        dto.setGender(form.getGender());
        dto.setPhone(form.getPhone());

        dto.setStatus("Inactive");
        dto.setRoleId(2L);

        baseService.register(dto, userContext);

        res.setSuccess(true);
        res.addMessage("User has been registered successfully..!!");
        return res;
    }

    /**
     * Logs out the current user by invalidating the HTTP session.
     *
     * @param session the HTTP session to invalidate
     * @return ORSResponse with logout success message
     * @throws Exception if an error occurs during logout
     */
    @GetMapping("logout")
    public ORSResponse logout(HttpSession session) throws Exception {

        ORSResponse res = new ORSResponse();

        session.invalidate();

        res.addMessage("Logout successfully..!!");

        return res;
    }
    @PostMapping("forgetPassword")
	public ORSResponse forgetPassword(@RequestBody @Valid ForgetPasswordForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO fDto = baseService.forgotPassword(form.getLoginId());

		if (fDto == null) {
			res.setSuccess(false);
			res.addMessage("LoginId / Email not found.");
			return res;
		} else {
			res.setSuccess(true);
			res.addMessage("Hello " + fDto.getFirstName() + " " + fDto.getLastName()
					+ "..! Your password has been sent on your email.");
		}
		return res;
	}

}