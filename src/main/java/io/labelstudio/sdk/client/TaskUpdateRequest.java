package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Request object for updating a task.
 */
public class TaskUpdateRequest {
    
    @JsonProperty("data")
    private Map<String, Object> data;
    
    @JsonProperty("meta")
    private Map<String, Object> meta;
    
    /**
     * Default constructor.
     */
    public TaskUpdateRequest() {
    }
    
    /**
     * Gets the task data.
     * 
     * @return the task data
     */
    public Map<String, Object> getData() {
        return data;
    }
    
    /**
     * Sets the task data.
     * 
     * @param data the task data
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    /**
     * Gets the task metadata.
     * 
     * @return the task metadata
     */
    public Map<String, Object> getMeta() {
        return meta;
    }
    
    /**
     * Sets the task metadata.
     * 
     * @param meta the task metadata
     */
    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
    
    /**
     * Creates a new builder for TaskUpdateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for TaskUpdateRequest.
     */
    public static class Builder {
        private final TaskUpdateRequest request = new TaskUpdateRequest();
        
        /**
         * Sets the task data.
         * 
         * @param data the task data
         * @return this builder
         */
        public Builder data(Map<String, Object> data) {
            request.setData(data);
            return this;
        }
        
        /**
         * Sets the task metadata.
         * 
         * @param meta the task metadata
         * @return this builder
         */
        public Builder meta(Map<String, Object> meta) {
            request.setMeta(meta);
            return this;
        }
        
        /**
         * Builds the TaskUpdateRequest.
         * 
         * @return the TaskUpdateRequest instance
         */
        public TaskUpdateRequest build() {
            return request;
        }
    }
}