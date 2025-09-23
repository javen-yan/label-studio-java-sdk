package io.labelstudio.sdk.core;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Options for customizing individual API requests.
 */
public class RequestOptions {
    
    private final Duration timeout;
    private final Map<String, String> additionalHeaders;
    
    private RequestOptions(Builder builder) {
        this.timeout = builder.timeout;
        this.additionalHeaders = new HashMap<>(builder.additionalHeaders);
    }
    
    /**
     * Gets the request timeout.
     * 
     * @return the timeout, or null if not set
     */
    public Duration getTimeout() {
        return timeout;
    }
    
    /**
     * Gets additional headers for this request.
     * 
     * @return a map of additional headers
     */
    public Map<String, String> getAdditionalHeaders() {
        return new HashMap<>(additionalHeaders);
    }
    
    /**
     * Creates a new builder for RequestOptions.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for RequestOptions.
     */
    public static class Builder {
        private Duration timeout;
        private Map<String, String> additionalHeaders = new HashMap<>();
        
        /**
         * Sets the request timeout.
         * 
         * @param timeout the timeout duration
         * @return this builder
         */
        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }
        
        /**
         * Adds an additional header.
         * 
         * @param name the header name
         * @param value the header value
         * @return this builder
         */
        public Builder addHeader(String name, String value) {
            this.additionalHeaders.put(name, value);
            return this;
        }
        
        /**
         * Adds multiple additional headers.
         * 
         * @param headers the headers to add
         * @return this builder
         */
        public Builder addHeaders(Map<String, String> headers) {
            this.additionalHeaders.putAll(headers);
            return this;
        }
        
        /**
         * Builds the RequestOptions.
         * 
         * @return the RequestOptions instance
         */
        public RequestOptions build() {
            return new RequestOptions(this);
        }
    }
}