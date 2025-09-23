package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a machine learning backend in Label Studio.
 */
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
    
    // Constructors
    public MlBackend() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getModelVersion() {
        return modelVersion;
    }
    
    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
    
    public Boolean getIsInteractive() {
        return isInteractive;
    }
    
    public void setIsInteractive(Boolean isInteractive) {
        this.isInteractive = isInteractive;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    
    public Boolean getAutoUpdate() {
        return autoUpdate;
    }
    
    public void setAutoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }
    
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public String getAuthMethod() {
        return authMethod;
    }
    
    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }
    
    public String getBasicAuthUser() {
        return basicAuthUser;
    }
    
    public void setBasicAuthUser(String basicAuthUser) {
        this.basicAuthUser = basicAuthUser;
    }
    
    public String getBasicAuthPass() {
        return basicAuthPass;
    }
    
    public void setBasicAuthPass(String basicAuthPass) {
        this.basicAuthPass = basicAuthPass;
    }
    
    public Map<String, Object> getExtraParams() {
        return extraParams;
    }
    
    public void setExtraParams(Map<String, Object> extraParams) {
        this.extraParams = extraParams;
    }
    
    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }
    
    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
    
    public LocalDateTime getUpdatedDatetime() {
        return updatedDatetime;
    }
    
    public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getModelName() {
        return modelName;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    public Integer getPredictionsCount() {
        return predictionsCount;
    }
    
    public void setPredictionsCount(Integer predictionsCount) {
        this.predictionsCount = predictionsCount;
    }
    
    public Integer getTrainingCount() {
        return trainingCount;
    }
    
    public void setTrainingCount(Integer trainingCount) {
        this.trainingCount = trainingCount;
    }
    
    public Boolean getIsTraining() {
        return isTraining;
    }
    
    public void setIsTraining(Boolean isTraining) {
        this.isTraining = isTraining;
    }
    
    public String getTrainingJob() {
        return trainingJob;
    }
    
    public void setTrainingJob(String trainingJob) {
        this.trainingJob = trainingJob;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public List<String> getSupportedFormats() {
        return supportedFormats;
    }
    
    public void setSupportedFormats(List<String> supportedFormats) {
        this.supportedFormats = supportedFormats;
    }
}