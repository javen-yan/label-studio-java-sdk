package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the response from a token refresh request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenRefreshResponse {
    
    @JsonProperty("access")
    private String access;
    
    @JsonProperty("refresh")
    private String refresh;
    
    /**
     * Default constructor.
     */
    public TokenRefreshResponse() {
    }
    
    /**
     * Gets the access token.
     * 
     * @return the access token
     */
    public String getAccess() {
        return access;
    }
    
    /**
     * Sets the access token.
     * 
     * @param access the access token
     */
    public void setAccess(String access) {
        this.access = access;
    }
    
    /**
     * Gets the refresh token.
     * 
     * @return the refresh token
     */
    public String getRefresh() {
        return refresh;
    }
    
    /**
     * Sets the refresh token.
     * 
     * @param refresh the refresh token
     */
    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenRefreshResponse that = (TokenRefreshResponse) o;
        return Objects.equals(access, that.access);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(access);
    }
    
    @Override
    public String toString() {
        return "TokenRefreshResponse{" +
                "access='" + (access != null ? access.substring(0, Math.min(20, access.length())) + "..." : null) + '\'' +
                ", refresh='" + (refresh != null ? refresh.substring(0, Math.min(20, refresh.length())) + "..." : null) + '\'' +
                '}';
    }
}

