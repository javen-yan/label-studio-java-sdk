package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Request object for updating an annotation.
 */
public class AnnotationUpdateRequest {
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("ground_truth")
    private Boolean groundTruth;
    
    @JsonProperty("lead_time")
    private Double leadTime;
    
    public AnnotationUpdateRequest() {
    }
    
    public List<Map<String, Object>> getResult() {
        return result;
    }
    
    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }
    
    public Boolean getGroundTruth() {
        return groundTruth;
    }
    
    public void setGroundTruth(Boolean groundTruth) {
        this.groundTruth = groundTruth;
    }
    
    public Double getLeadTime() {
        return leadTime;
    }
    
    public void setLeadTime(Double leadTime) {
        this.leadTime = leadTime;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final AnnotationUpdateRequest request = new AnnotationUpdateRequest();
        
        public Builder result(List<Map<String, Object>> result) {
            request.setResult(result);
            return this;
        }
        
        public Builder groundTruth(boolean groundTruth) {
            request.setGroundTruth(groundTruth);
            return this;
        }
        
        public Builder leadTime(double leadTime) {
            request.setLeadTime(leadTime);
            return this;
        }
        
        public AnnotationUpdateRequest build() {
            return request;
        }
    }
}