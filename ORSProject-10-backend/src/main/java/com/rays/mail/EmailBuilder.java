package com.rays.mail;

import java.util.HashMap;

/**
 * EmailBuilder is a utility class that constructs HTML email messages
 * for various user-related notifications.
 * 
 * <p>This class provides static methods to build email content for
 * user registration confirmation, password recovery, and password
 * change notifications. All messages are formatted in HTML for better
 * presentation in email clients.</p>
 *
 * @author sanjana gangrade
 */
public class EmailBuilder {

    /**
     * Builds an HTML email message for user registration confirmation.
     *
     * @param map a HashMap containing user details with keys:
     *            "login" - the user's login ID
     *            "password" - the user's password
     * @return HTML formatted string containing the registration welcome message
     */
    public static String getUserRegistrationMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Welcome to ORS, ").append(map.get("login")).append("!</H1>");
        msg.append("<P>Your registration is successful. You can now log in and manage your account.</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login")).append("<BR>Password: ").append(map.get("password"))
                .append("</B></P>");
        msg.append("<P>Change your password after logging in for security reasons.</P>");
        msg.append("<P>For support, contact +91 98273 60504 or hrd@sunrays.co.in.</P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }

    /**
     * Builds an HTML email message for password recovery.
     *
     * @param map a HashMap containing user details with keys:
     *            "firstName" - the user's first name
     *            "lastName" - the user's last name
     *            "login" - the user's login ID
     *            "password" - the user's password
     * @return HTML formatted string containing the password recovery message
     */
    public static String getForgetPasswordMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Password Recovery</H1>");
        msg.append("<P>Hello, ").append(map.get("firstName")).append(" ").append(map.get("lastName")).append(".</P>");
        msg.append("<P>Your login details are:</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login")).append("<BR>Password: ").append(map.get("password"))
                .append("</B></P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }

    /**
     * Builds an HTML email message for password change confirmation.
     *
     * @param map a HashMap containing user details with keys:
     *            "firstName" - the user's first name
     *            "lastName" - the user's last name
     *            "login" - the user's login ID
     *            "password" - the user's new password
     * @return HTML formatted string containing the password change confirmation message
     */
    public static String getChangePasswordMessage(HashMap<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg.append("<HTML><BODY>");
        msg.append("<H1>Password Changed Successfully</H1>");
        msg.append("<P>Dear ").append(map.get("firstName")).append(" ").append(map.get("lastName"))
                .append(", your password has been updated.</P>");
        msg.append("<P>Your updated login details are:</P>");
        msg.append("<P><B>Login Id: ").append(map.get("login")).append("<BR>New Password: ").append(map.get("password"))
                .append("</B></P>");
        msg.append("</BODY></HTML>");
        return msg.toString();
    }
}