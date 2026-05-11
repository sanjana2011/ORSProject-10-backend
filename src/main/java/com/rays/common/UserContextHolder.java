package com.rays.common;

/**
 * UserContextHolder class provides a thread-local storage mechanism for
 * managing {@link UserContext} objects. This class ensures that user context
 * is maintained per thread, making it suitable for web applications where
 * each request is processed by a separate thread.
 * 
 * <p>This class is typically used to store the current user's context
 * during request processing and retrieve it from anywhere within the same
 * thread without explicitly passing the context object.</p>
 *
 * @author sanjana gangrade
 */
public class UserContextHolder {

    /** ThreadLocal instance to store UserContext per thread. */
    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    /**
     * Sets the UserContext for the current thread.
     *
     * @param context the UserContext to set for the current thread
     */
    public static void setContext(UserContext context) {
        threadLocal.set(context);
    }

    /**
     * Gets the UserContext for the current thread.
     *
     * @return the UserContext associated with the current thread,
     *         or null if no context has been set
     */
    public static UserContext getContext() {
        return threadLocal.get();
    }

    /**
     * Clears the UserContext for the current thread.
     * This method removes the context from the thread-local storage
     * and is typically called after request processing to prevent
     * memory leaks.
     */
    public static void clear() {
        threadLocal.remove();
    }
}