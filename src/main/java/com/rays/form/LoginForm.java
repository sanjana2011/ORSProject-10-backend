package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * LoginForm is a form class used for capturing user login credentials.
 * This class contains fields for login ID and password with validation constraints.
 * 
 * <p>This form is used to collect and validate user authentication details
 * such as login ID (email) and password during the login process.</p>
 *
 * @author sanjana gangrade
 */
public class LoginForm {

    /** The login ID (email) of the user. Must be a valid email format. */
    @NotEmpty(message = "Login Id is required")
    @Email
    private String loginId;

    /** The password of the user. */
    @NotEmpty(message = "Password is required")
    private String password;

    /**
     * Gets the login ID.
     *
     * @return the login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login ID.
     *
     * @param loginId the login ID to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}