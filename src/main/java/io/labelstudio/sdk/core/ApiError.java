package io.labelstudio.sdk.core;

/**
 * Exception thrown when API calls fail.
 */
public class ApiError extends RuntimeException {
    
    private final int statusCode;
    private final String body;
    
    /**
     * Constructs a new API error.
     * 
     * @param message the error message
     */
    public ApiError(String message) {
        super(message);
        this.statusCode = -1;
        this.body = message;
    }
    
    /**
     * Constructs a new API error with status code and response body.
     * 
     * @param message the error message
     * @param statusCode the HTTP status code
     * @param body the response body
     */
    public ApiError(String message, int statusCode, String body) {
        super(message);
        this.statusCode = statusCode;
        this.body = body;
    }
    
    /**
     * Gets the HTTP status code.
     * 
     * @return the status code, or -1 if not available
     */
    public int getStatusCode() {
        return statusCode;
    }
    
    /**
     * Gets the response body.
     * 
     * @return the response body
     */
    public String getBody() {
        return body;
    }
}