package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ORSResponse class represents the standard response object for API endpoints.
 * This class encapsulates the response data, status, and messages to be sent
 * back to the client. It provides methods to add different types of response
 * data including validation errors, success messages, and custom data objects.
 *
 * @author sanjana gangrade
 */
public class ORSResponse {

    /** Constant key for input validation errors. */
    public static final String INPUT_ERROR = "inputerror";
    
    /** Constant key for response messages. */
    public static final String MESSAGE = "message";
    
    /** Constant key for response data. */
    public static final String DATA = "data";

    /** Map that holds the actual response data. */
    private Map<String, Object> result = new HashMap<String, Object>();

    /** Flag indicating whether the operation was successful. */
    public boolean success = false;

    /**
     * Default constructor.
     * Creates an empty ORSResponse with success flag set to false.
     */
    public ORSResponse() {
    }

    /**
     * Constructs an ORSResponse with the specified success flag.
     *
     * @param success the success status of the operation
     */
    public ORSResponse(boolean success) {
        this.success = success;
    }

    /**
     * Constructs an ORSResponse with success flag and a message.
     *
     * @param success the success status of the operation
     * @param message the message to be added to the response
     */
    public ORSResponse(boolean success, String message) {
        this.success = success;
        addMessage(message);
    }

    /**
     * Constructs an ORSResponse with success flag, message, and data.
     *
     * @param success the success status of the operation
     * @param message the message to be added to the response
     * @param value the data value to be added to the response
     */
    public ORSResponse(boolean success, String message, Object value) {
        this.success = success;
        addMessage(message);
        addData(value);
    }

    /**
     * Gets the success status of the operation.
     *
     * @return true if the operation was successful, false otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success status of the operation.
     *
     * @param success the success status to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets the result map containing all response data.
     *
     * @return the result map
     */
    public Map<String, Object> getResult() {
        return result;
    }

    /**
     * Sets the result map.
     *
     * @param result the result map to set
     */
    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    /**
     * Adds input validation error to the response.
     * The errors are stored under the {@link #INPUT_ERROR} key.
     *
     * @param value the validation error object to add
     */
    public void addInputError(Object value) {
        result.put(INPUT_ERROR, value);
    }

    /**
     * Adds a message to the response.
     * The message is stored under the {@link #MESSAGE} key.
     *
     * @param value the message object to add
     */
    public void addMessage(Object value) {
        result.put(MESSAGE, value);
    }

    /**
     * Adds data to the response.
     * The data is stored under the {@link #DATA} key.
     *
     * @param value the data object to add
     */
    public void addData(Object value) {
        result.put(DATA, value);
    }

    /**
     * Adds a custom key-value pair to the response result.
     *
     * @param key the key for the custom data
     * @param value the value for the custom data
     */
    public void addResult(String key, Object value) {
        result.put(key, value);
    }
}