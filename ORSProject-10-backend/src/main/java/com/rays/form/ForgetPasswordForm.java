package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

/**
 * ForgetPasswordForm is a form class used for capturing forgot password requests.
 * This class extends {@link BaseForm} and contains the login ID field with
 * validation constraint.
 * 
 * <p>This form is used when a user forgets their password and needs to request
 * a password reset. The login ID is used to identify the user and send
 * password recovery instructions via email.</p>
 *
 * @author sanjana gangrade
 */
public class ForgetPasswordForm extends BaseForm {

    /** The login ID of the user requesting password recovery. */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

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
}