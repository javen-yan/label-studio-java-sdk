package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewCreateRequest {
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("action") private String action;
    @JsonProperty("comment") private String comment;
    @JsonProperty("score") private Double score;
    
    private ReviewCreateRequest(Builder builder) {
        this.annotationId = builder.annotationId;
        this.action = builder.action;
        this.comment = builder.comment;
        this.score = builder.score;
    }
    
    public static Builder builder() { return new Builder(); }
    
    public Integer getAnnotationId() { return annotationId; }
    public String getAction() { return action; }
    public String getComment() { return comment; }
    public Double getScore() { return score; }
    
    public static class Builder {
        private Integer annotationId;
        private String action;
        private String comment;
        private Double score;
        
        public Builder annotationId(Integer annotationId) { this.annotationId = annotationId; return this; }
        public Builder action(String action) { this.action = action; return this; }
        public Builder comment(String comment) { this.comment = comment; return this; }
        public Builder score(Double score) { this.score = score; return this; }
        public Builder accept() { this.action = "accept"; return this; }
        public Builder reject() { this.action = "reject"; return this; }
        
        public ReviewCreateRequest build() { return new ReviewCreateRequest(this); }
    }
}