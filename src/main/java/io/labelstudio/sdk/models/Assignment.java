package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * Represents a task assignment in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("task")
    private Integer taskId;
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("assigned_by")
    private Integer assignedBy;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("assigned_at")
    private OffsetDateTime assignedAt;
    
    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;
    
    @JsonProperty("user_name")
    private String userName;
    
    @JsonProperty("assigned_by_name")
    private String assignedByName;
}
