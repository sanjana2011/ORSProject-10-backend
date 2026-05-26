package com.rays.mail;

/**
 * EmailMessage is a POJO (Plain Old Java Object) class that encapsulates
 * email message details for sending emails through the email service.
 * 
 * <p>This class stores recipient address, subject, message content, and
 * message type (HTML or plain text). It is used by the email service to
 * construct and send emails.</p>
 *
 * @author sanjana gangrade
 */
public class EmailMessage {

    /** The recipient email address. */
    private String to;
    
    /** The subject of the email. */
    private String subject;
    
    /** The content/message body of the email. */
    private String message;
    
    /** The type of message (HTML or TEXT). Default is TEXT_MSG. */
    private int messageType = TEXT_MSG;

    /** Constant representing HTML message type. */
    public static final int HTML_MSG = 1;
    
    /** Constant representing plain text message type. */
    public static final int TEXT_MSG = 2;

    /**
     * Default constructor.
     */
    public EmailMessage() {
    }

    /**
     * Constructs an EmailMessage with the specified recipient, subject, and message.
     *
     * @param to the recipient email address
     * @param subject the email subject
     * @param message the email message content
     */
    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Sets the recipient email address.
     *
     * @param to the recipient email address to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the recipient email address.
     *
     * @return the recipient email address
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the email subject.
     *
     * @param subject the email subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the email subject.
     *
     * @return the email subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the email message content.
     *
     * @param message the email message content to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the email message content.
     *
     * @return the email message content
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message type (HTML or plain text).
     *
     * @param messageType the message type to set (EmailMessage.HTML_MSG or EmailMessage.TEXT_MSG)
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    /**
     * Gets the message type.
     *
     * @return the message type (HTML_MSG or TEXT_MSG)
     */
    public int getMessageType() {
        return messageType;
    }
}