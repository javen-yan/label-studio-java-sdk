package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.models.UserSimple;

/**
 * Client for managing Label Studio users.
 */
public class UsersClient {
    
    private final HttpClient httpClient;
    
    public UsersClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Gets information about the current user.
     * 
     * @return the current user information
     */
    public UserSimple whoami() {
        return httpClient.get("/api/users/whoami/", UserSimple.class);
    }
    
    /**
     * Gets a user by ID.
     * 
     * @param id the user ID
     * @return the user
     */
    public UserSimple get(int id) {
        return httpClient.get("/api/users/" + id + "/", UserSimple.class);
    }
}