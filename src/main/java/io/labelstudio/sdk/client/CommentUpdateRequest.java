package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentUpdateRequest {
    @JsonProperty("text") private String text;
    @JsonProperty("is_resolved") private Boolean isResolved;
    
    private CommentUpdateRequest(Builder builder) {
        this.text = builder.text;
        this.isResolved = builder.isResolved;
    }
    
    public static Builder builder() { return new Builder(); }
    
    public String getText() { return text; }
    public Boolean getIsResolved() { return isResolved; }
    
    public static class Builder {
        private String text;
        private Boolean isResolved;
        
        public Builder text(String text) { this.text = text; return this; }
        public Builder isResolved(Boolean isResolved) { this.isResolved = isResolved; return this; }
        public Builder resolve() { this.isResolved = true; return this; }
        public Builder unresolve() { this.isResolved = false; return this; }
        
        public CommentUpdateRequest build() { return new CommentUpdateRequest(this); }
    }
}