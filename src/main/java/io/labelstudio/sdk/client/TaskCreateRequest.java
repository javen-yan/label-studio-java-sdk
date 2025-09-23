package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Request object for creating a new task.
 */
public class TaskCreateRequest {
    
    @JsonProperty("data")
    private Map<String, Object> data;
    
    @JsonProperty("meta")
    private Map<String, Object> meta;
    
    @JsonProperty("project")
    private Integer project;
    
    /**
     * Default constructor.
     */
    public TaskCreateRequest() {
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
     * Gets the project ID.
     * 
     * @return the project ID
     */
    public Integer getProject() {
        return project;
    }
    
    /**
     * Sets the project ID.
     * 
     * @param project the project ID
     */
    public void setProject(Integer project) {
        this.project = project;
    }
    
    /**
     * Creates a new builder for TaskCreateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for TaskCreateRequest.
     */
    public static class Builder {
        private final TaskCreateRequest request = new TaskCreateRequest();
        
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
         * Sets the project ID.
         * 
         * @param project the project ID
         * @return this builder
         */
        public Builder project(int project) {
            request.setProject(project);
            return this;
        }
        
        /**
         * Builds the TaskCreateRequest.
         * 
         * @return the TaskCreateRequest instance
         */
        public TaskCreateRequest build() {
            return request;
        }
    }
}