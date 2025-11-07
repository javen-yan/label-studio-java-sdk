package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a prediction for a task.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("score")
    private Double score;
    
    @JsonProperty("cluster")
    private Integer cluster;
    
    @JsonProperty("neighbors")
    private List<Map<String, Object>> neighbors;
    
    @JsonProperty("mislabeling")
    private Double mislabeling;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("updated_by")
    private Integer updatedBy;
    
    @JsonProperty("import_id")
    private Integer importId;
    
    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", task=" + task +
                ", project=" + project +
                ", score=" + score +
                ", modelVersion='" + modelVersion + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
