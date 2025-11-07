package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a machine learning backend in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MlBackend {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    @JsonProperty("is_interactive")
    private Boolean isInteractive;
    
    @JsonProperty("timeout")
    private Integer timeout;
    
    @JsonProperty("auto_update")
    private Boolean autoUpdate;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("auth_method")
    private String authMethod;
    
    @JsonProperty("basic_auth_user")
    private String basicAuthUser;
    
    @JsonProperty("basic_auth_pass")
    private String basicAuthPass;
    
    @JsonProperty("extra_params")
    private Map<String, Object> extraParams;
    
    @JsonProperty("created_datetime")
    private LocalDateTime createdDatetime;
    
    @JsonProperty("updated_datetime")
    private LocalDateTime updatedDatetime;
    
    @JsonProperty("state")
    private String state;
    
    @JsonProperty("error_message")
    private String errorMessage;
    
    @JsonProperty("model_name")
    private String modelName;
    
    @JsonProperty("predictions_count")
    private Integer predictionsCount;
    
    @JsonProperty("training_count")
    private Integer trainingCount;
    
    @JsonProperty("is_training")
    private Boolean isTraining;
    
    @JsonProperty("training_job")
    private String trainingJob;
    
    @JsonProperty("tag")
    private String tag;
    
    @JsonProperty("supported_formats")
    private List<String> supportedFormats;
}
