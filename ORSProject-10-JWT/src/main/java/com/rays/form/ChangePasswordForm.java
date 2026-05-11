package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.rays.common.BaseForm;

/**
 * ChangePasswordForm is a form class used for capturing password change requests.
 * This class extends {@link BaseForm} and contains fields for old password,
 * new password, and login ID with validation constraints.
 * 
 * <p>This form is used when a user wants to change their password, requiring
 * validation of the old password before updating to the new password.</p>
 *
 * @author sanjana gangrade
 */
public class ChangePasswordForm extends BaseForm {

    /** The old password entered by the user for verification. */
    @NotEmpty(message = "Old Password is required")
    @Size(min = 2, max = 10)
    private String oldPassword;

    /** The new password to be set for the user account. */
    @NotEmpty(message = "New Password is required")
    @Size(min = 2, max = 10)
    private String newPassword;

    /** The login ID of the user changing the password. */
    private String loginId;

    /**
     * Gets the old password.
     *
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the old password.
     *
     * @param oldPassword the old password to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Gets the new password.
     *
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     *
     * @param newPassword the new password to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

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