package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for duplicating a project.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
