package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for duplicating a project.
 */
public class ProjectDuplicateRequest {
    
    /**
     * Enumeration of duplication modes.
     */
    public enum Mode {
        @JsonProperty("empty_project")
        EMPTY_PROJECT,
        
        @JsonProperty("project_with_tasks")
        PROJECT_WITH_TASKS,
        
        @JsonProperty("project_with_tasks_and_annotations")
        PROJECT_WITH_TASKS_AND_ANNOTATIONS
    }
    
    @JsonProperty("mode")
    private Mode mode;
    
    @JsonProperty("title")
    private String title;
    
    /**
     * Default constructor.
     */
    public ProjectDuplicateRequest() {
    }
    
    /**
     * Gets the duplication mode.
     * 
     * @return the duplication mode
     */
    public Mode getMode() {
        return mode;
    }
    
    /**
     * Sets the duplication mode.
     * 
     * @param mode the duplication mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
    /**
     * Gets the title for the duplicated project.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title for the duplicated project.
     * 
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Creates a new builder for ProjectDuplicateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ProjectDuplicateRequest.
     */
    public static class Builder {
        private final ProjectDuplicateRequest request = new ProjectDuplicateRequest();
        
        /**
         * Sets the duplication mode.
         * 
         * @param mode the duplication mode
         * @return this builder
         */
        public Builder mode(Mode mode) {
            request.setMode(mode);
            return this;
        }
        
        /**
         * Sets the mode to duplicate as empty project.
         * 
         * @return this builder
         */
        public Builder emptyProject() {
            request.setMode(Mode.EMPTY_PROJECT);
            return this;
        }
        
        /**
         * Sets the mode to duplicate project with tasks.
         * 
         * @return this builder
         */
        public Builder projectWithTasks() {
            request.setMode(Mode.PROJECT_WITH_TASKS);
            return this;
        }
        
        /**
         * Sets the mode to duplicate project with tasks and annotations.
         * 
         * @return this builder
         */
        public Builder projectWithTasksAndAnnotations() {
            request.setMode(Mode.PROJECT_WITH_TASKS_AND_ANNOTATIONS);
            return this;
        }
        
        /**
         * Sets the title for the duplicated project.
         * 
         * @param title the title
         * @return this builder
         */
        public Builder title(String title) {
            request.setTitle(title);
            return this;
        }
        
        /**
         * Builds the ProjectDuplicateRequest.
         * 
         * @return the ProjectDuplicateRequest instance
         */
        public ProjectDuplicateRequest build() {
            return request;
        }
    }
}