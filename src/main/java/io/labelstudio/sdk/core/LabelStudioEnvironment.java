package io.labelstudio.sdk.core;

/**
 * Enumeration of available Label Studio environments.
 */
public enum LabelStudioEnvironment {
    /**
     * Default environment (localhost).
     */
    DEFAULT("http://localhost:8080"),
    
    /**
     * Production environment.
     */
    PRODUCTION("https://app.labelstud.io"),
    
    /**
     * Staging environment.
     */
    STAGING("https://staging.labelstud.io");
    
    private final String url;
    
    LabelStudioEnvironment(String url) {
        this.url = url;
    }
    
    /**
     * Gets the base URL for this environment.
     * 
     * @return the base URL
     */
    public String getUrl() {
        return url;
    }
}