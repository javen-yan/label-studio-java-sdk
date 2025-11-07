package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.TokenRefreshResponse;
import io.labelstudio.sdk.models.User;
import io.labelstudio.sdk.models.UserSimple;
import io.labelstudio.sdk.vo.UserHotkeysRequest;
import io.labelstudio.sdk.vo.UserUpdateRequest;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import io.labelstudio.sdk.models.LoginResponse;

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
        return httpClient.get("/api/current-user/whoami", UserSimple.class);
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

    /**
     * Creates a user.
     * 
     * @param user the user
     * @return the created user
     */
    public UserSimple create(String username, String email, String password) {
        Map<String, Object> body = new HashMap<>();
        body.put("username", username);
        body.put("email", email);
        body.put("password", password);
        return httpClient.post("/api/users", body, UserSimple.class);
    }

    /**
     * Logs in a user.
     * 
     * @param email the email
     * @param password the password
     * @return the login response
     */
    public LoginResponse login(String email, String password) {
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        return httpClient.post("/api/login", body, LoginResponse.class);
    }
    
    /**
     * Refreshes an access token using a refresh token.
     * 
     * @param refreshToken the refresh token
     * @return the token refresh response containing new access and refresh tokens
     */
    public TokenRefreshResponse refreshToken(String refreshToken) {
        Map<String, Object> body = new HashMap<>();
        body.put("refresh", refreshToken);
        
        return httpClient.post("/api/token/refresh/", body, TokenRefreshResponse.class);
    }
    
    /**
     * Lists all users.
     * 
     * @return a paginated list of users
     */
    public Pagination<UserSimple> list() {
        return list(null);
    }
    
    /**
     * Lists all users with options.
     * 
     * @param options request options
     * @return a paginated list of users
     */
    public Pagination<UserSimple> list(RequestOptions options) {
        return httpClient.getPaginated("/api/users/", UserSimple.class);
    }
    
    /**
     * Lists all users asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of users
     */
    public CompletableFuture<Pagination<UserSimple>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all users with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing a paginated list of users
     */
    public CompletableFuture<Pagination<UserSimple>> listAsync(RequestOptions options) {
        return httpClient.getPaginatedAsync("/api/users/", UserSimple.class);
    }
    
    /**
     * Gets information about the current user.
     * 
     * @return the current user information
     */
    public User getCurrentUser() {
        return getCurrentUser(null);
    }
    
    /**
     * Gets information about the current user with options.
     * 
     * @param options request options
     * @return the current user information
     */
    public User getCurrentUser(RequestOptions options) {
        return httpClient.get("/api/current-user/", User.class);
    }
    
    /**
     * Gets information about the current user asynchronously.
     * 
     * @return a CompletableFuture containing the current user information
     */
    public CompletableFuture<User> getCurrentUserAsync() {
        return getCurrentUserAsync(null);
    }
    
    /**
     * Gets information about the current user with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing the current user information
     */
    public CompletableFuture<User> getCurrentUserAsync(RequestOptions options) {
        return httpClient.getAsync("/api/current-user/", User.class);
    }
    
    /**
     * Updates the current user's information.
     * 
     * @param request the user update request
     * @return the updated user
     */
    public User updateCurrentUser(UserUpdateRequest request) {
        return updateCurrentUser(request, null);
    }
    
    /**
     * Updates the current user's information with options.
     * 
     * @param request the user update request
     * @param options request options
     * @return the updated user
     */
    public User updateCurrentUser(UserUpdateRequest request, RequestOptions options) {
        return httpClient.patch("/api/current-user/", request, User.class);
    }
    
    /**
     * Updates the current user's information asynchronously.
     * 
     * @param request the user update request
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<User> updateCurrentUserAsync(UserUpdateRequest request) {
        return updateCurrentUserAsync(request, null);
    }
    
    /**
     * Updates the current user's information with options asynchronously.
     * 
     * @param request the user update request
     * @param options request options
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<User> updateCurrentUserAsync(UserUpdateRequest request, RequestOptions options) {
        return httpClient.patchAsync("/api/current-user/", request, User.class);
    }
    
    /**
     * Gets user hotkeys.
     * 
     * @return the user hotkeys
     */
    public Map<String, Object> getHotkeys() {
        return getHotkeys(null);
    }
    
    /**
     * Gets user hotkeys with options.
     * 
     * @param options request options
     * @return the user hotkeys
     */
    public Map<String, Object> getHotkeys(RequestOptions options) {
        User user = httpClient.get("/api/current-user/hotkeys/", User.class);
        return user != null ? user.getCustomHotkeys() : null;
    }
    
    /**
     * Gets user hotkeys asynchronously.
     * 
     * @return a CompletableFuture containing the user hotkeys
     */
    public CompletableFuture<Map<String, Object>> getHotkeysAsync() {
        return getHotkeysAsync(null);
    }
    
    /**
     * Gets user hotkeys with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing the user hotkeys
     */
    public CompletableFuture<Map<String, Object>> getHotkeysAsync(RequestOptions options) {
        return httpClient.getAsync("/api/current-user/hotkeys/", User.class)
            .thenApply(user -> user != null ? user.getCustomHotkeys() : null);
    }
    
    /**
     * Updates user hotkeys.
     * 
     * @param request the hotkeys update request
     * @return the updated user
     */
    public User updateHotkeys(UserHotkeysRequest request) {
        return updateHotkeys(request, null);
    }
    
    /**
     * Updates user hotkeys with options.
     * 
     * @param request the hotkeys update request
     * @param options request options
     * @return the updated user
     */
    public User updateHotkeys(UserHotkeysRequest request, RequestOptions options) {
        return httpClient.patch("/api/current-user/hotkeys/", request, User.class);
    }
    
    /**
     * Updates user hotkeys asynchronously.
     * 
     * @param request the hotkeys update request
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<User> updateHotkeysAsync(UserHotkeysRequest request) {
        return updateHotkeysAsync(request, null);
    }
    
    /**
     * Updates user hotkeys with options asynchronously.
     * 
     * @param request the hotkeys update request
     * @param options request options
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<User> updateHotkeysAsync(UserHotkeysRequest request, RequestOptions options) {
        return httpClient.patchAsync("/api/current-user/hotkeys/", request, User.class);
    }
    
    /**
     * Gets the user's API token.
     * 
     * @return the user token
     */
    public String getToken() {
        return getToken(null);
    }
    
    /**
     * Gets the user's API token with options.
     * 
     * @param options request options
     * @return the user token
     */
    @SuppressWarnings("unchecked")
    public String getToken(RequestOptions options) {
        Map<String, Object> response = (Map<String, Object>) httpClient.get("/api/current-user/token/", Map.class);
        return response != null && response.containsKey("token") ? (String) response.get("token") : null;
    }
    
    /**
     * Gets the user's API token asynchronously.
     * 
     * @return a CompletableFuture containing the user token
     */
    public CompletableFuture<String> getTokenAsync() {
        return getTokenAsync(null);
    }
    
    /**
     * Gets the user's API token with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing the user token
     */
    @SuppressWarnings("unchecked")
    public CompletableFuture<String> getTokenAsync(RequestOptions options) {
        return httpClient.getAsync("/api/current-user/token/", Map.class)
            .thenApply(response -> {
                Map<String, Object> map = (Map<String, Object>) response;
                return map != null && map.containsKey("token") 
                    ? (String) map.get("token") : null;
            });
    }
    
    /**
     * Resets the user's API token.
     * 
     * @return the new user token
     */
    public String resetToken() {
        return resetToken(null);
    }
    
    /**
     * Resets the user's API token with options.
     * 
     * @param options request options
     * @return the new user token
     */
    @SuppressWarnings("unchecked")
    public String resetToken(RequestOptions options) {
        Map<String, Object> response = (Map<String, Object>) httpClient.post("/api/current-user/reset-token/", null, Map.class);
        return response != null && response.containsKey("token") ? (String) response.get("token") : null;
    }
    
    /**
     * Resets the user's API token asynchronously.
     * 
     * @return a CompletableFuture containing the new user token
     */
    public CompletableFuture<String> resetTokenAsync() {
        return resetTokenAsync(null);
    }
    
    /**
     * Resets the user's API token with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing the new user token
     */
    @SuppressWarnings("unchecked")
    public CompletableFuture<String> resetTokenAsync(RequestOptions options) {
        return httpClient.postAsync("/api/current-user/reset-token/", null, Map.class)
            .thenApply(response -> {
                Map<String, Object> map = (Map<String, Object>) response;
                return map != null && map.containsKey("token") 
                    ? (String) map.get("token") : null;
            });
    }
    
    /**
     * Updates a user's details.
     * 
     * @param id the user ID
     * @param request the user update request
     * @return the updated user
     */
    public UserSimple update(int id, UserUpdateRequest request) {
        return update(id, request, null);
    }
    
    /**
     * Updates a user's details with options.
     * 
     * @param id the user ID
     * @param request the user update request
     * @param options request options
     * @return the updated user
     */
    public UserSimple update(int id, UserUpdateRequest request, RequestOptions options) {
        return httpClient.put("/api/users/" + id + "/", request, UserSimple.class);
    }
    
    /**
     * Updates a user's details asynchronously.
     * 
     * @param id the user ID
     * @param request the user update request
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<UserSimple> updateAsync(int id, UserUpdateRequest request) {
        return updateAsync(id, request, null);
    }
    
    /**
     * Updates a user's details with options asynchronously.
     * 
     * @param id the user ID
     * @param request the user update request
     * @param options request options
     * @return a CompletableFuture containing the updated user
     */
    public CompletableFuture<UserSimple> updateAsync(int id, UserUpdateRequest request, RequestOptions options) {
        return httpClient.putAsync("/api/users/" + id + "/", request, UserSimple.class);
    }
    
    /**
     * Deletes a user.
     * 
     * @param id the user ID to delete
     */
    public void delete(int id) {
        delete(id, null);
    }
    
    /**
     * Deletes a user with options.
     * 
     * @param id the user ID to delete
     * @param options request options
     */
    public void delete(int id, RequestOptions options) {
        httpClient.delete("/api/users/" + id + "/", Void.class);
    }
    
    /**
     * Deletes a user asynchronously.
     * 
     * @param id the user ID to delete
     * @return a CompletableFuture that completes when the user is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id) {
        return deleteAsync(id, null);
    }
    
    /**
     * Deletes a user with options asynchronously.
     * 
     * @param id the user ID to delete
     * @param options request options
     * @return a CompletableFuture that completes when the user is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id, RequestOptions options) {
        return httpClient.deleteAsync("/api/users/" + id + "/", Void.class);
    }
}