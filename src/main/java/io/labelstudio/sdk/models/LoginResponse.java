package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the response from a login request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    
    @JsonProperty("detail")
    private String detail;
    
    @JsonProperty("token")
    private String token;
    
    @JsonProperty("user")
    private User user;
    
    /**
     * Default constructor.
     */
    public LoginResponse() {
    }
    
    /**
     * Gets the detail message.
     * 
     * @return the detail message
     */
    public String getDetail() {
        return detail;
    }
    
    /**
     * Sets the detail message.
     * 
     * @param detail the detail message
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    /**
     * Gets the authentication token.
     * 
     * @return the authentication token
     */
    public String getToken() {
        return token;
    }
    
    /**
     * Sets the authentication token.
     * 
     * @param token the authentication token
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    /**
     * Gets the user object.
     * 
     * @return the user object
     */
    public User getUser() {
        return user;
    }
    
    /**
     * Sets the user object.
     * 
     * @param user the user object
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponse that = (LoginResponse) o;
        return Objects.equals(token, that.token);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
    
    @Override
    public String toString() {
        return "LoginResponse{" +
                "detail='" + detail + '\'' +
                ", token='" + (token != null ? token.substring(0, Math.min(20, token.length())) + "..." : null) + '\'' +
                ", user=" + user +
                '}';
    }
}
