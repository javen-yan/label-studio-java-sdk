package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.ProjectMember;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing project members in Label Studio.
 * 
 * <p>This client provides methods to list, create, update, and delete project members,
 * allowing you to manage who has access to a specific project and what their roles are.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * ProjectMembersClient membersClient = client.projects().members(projectId);
 * 
 * // List all members
 * Pagination&lt;ProjectMember&gt; members = membersClient.list();
 * 
 * // Add a new member
 * ProjectMember newMember = membersClient.create(
 *     MemberCreateRequest.builder()
 *         .userId(123)
 *         .annotator()
 *         .enabled()
 *         .build()
 * );
 * 
 * // Update member role
 * ProjectMember updated = membersClient.update(memberId,
 *     MemberUpdateRequest.builder()
 *         .reviewer()
 *         .build()
 * );
 * 
 * // Remove a member
 * membersClient.delete(memberId);
 * </pre>
 */
public class ProjectMembersClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    /**
     * Constructs a new project members client.
     * 
     * @param httpClient the HTTP client to use
     * @param projectId the project ID
     */
    public ProjectMembersClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Lists all members of the project.
     * 
     * @return a paginated list of project members
     */
    public Pagination<ProjectMember> list() {
        return list(null);
    }
    
    /**
     * Lists all members of the project with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of project members
     */
    public Pagination<ProjectMember> list(RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/";
        return httpClient.get(path, 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, ProjectMember.class));
    }
    
    /**
     * Lists all members of the project asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of project members
     */
    public CompletableFuture<Pagination<ProjectMember>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all members of the project with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of project members
     */
    public CompletableFuture<Pagination<ProjectMember>> listAsync(RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/";
        return httpClient.getAsync(path, 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, ProjectMember.class));
    }
    
    /**
     * Creates a new project member.
     * 
     * @param request the member creation request
     * @return the created project member
     */
    public ProjectMember create(MemberCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new project member with options.
     * 
     * @param request the member creation request
     * @param requestOptions request options
     * @return the created project member
     */
    public ProjectMember create(MemberCreateRequest request, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/";
        return httpClient.post(path, request, ProjectMember.class);
    }
    
    /**
     * Creates a new project member asynchronously.
     * 
     * @param request the member creation request
     * @return a CompletableFuture containing the created project member
     */
    public CompletableFuture<ProjectMember> createAsync(MemberCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new project member with options asynchronously.
     * 
     * @param request the member creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created project member
     */
    public CompletableFuture<ProjectMember> createAsync(MemberCreateRequest request, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/";
        return httpClient.postAsync(path, request, ProjectMember.class);
    }
    
    /**
     * Gets a project member by ID.
     * 
     * @param memberId the member ID
     * @return the project member
     */
    public ProjectMember get(int memberId) {
        return get(memberId, null);
    }
    
    /**
     * Gets a project member by ID with options.
     * 
     * @param memberId the member ID
     * @param requestOptions request options
     * @return the project member
     */
    public ProjectMember get(int memberId, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        return httpClient.get(path, ProjectMember.class);
    }
    
    /**
     * Gets a project member by ID asynchronously.
     * 
     * @param memberId the member ID
     * @return a CompletableFuture containing the project member
     */
    public CompletableFuture<ProjectMember> getAsync(int memberId) {
        return getAsync(memberId, null);
    }
    
    /**
     * Gets a project member by ID with options asynchronously.
     * 
     * @param memberId the member ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the project member
     */
    public CompletableFuture<ProjectMember> getAsync(int memberId, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        return httpClient.getAsync(path, ProjectMember.class);
    }
    
    /**
     * Updates a project member.
     * 
     * @param memberId the member ID
     * @param request the member update request
     * @return the updated project member
     */
    public ProjectMember update(int memberId, MemberUpdateRequest request) {
        return update(memberId, request, null);
    }
    
    /**
     * Updates a project member with options.
     * 
     * @param memberId the member ID
     * @param request the member update request
     * @param requestOptions request options
     * @return the updated project member
     */
    public ProjectMember update(int memberId, MemberUpdateRequest request, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        return httpClient.put(path, request, ProjectMember.class);
    }
    
    /**
     * Updates a project member asynchronously.
     * 
     * @param memberId the member ID
     * @param request the member update request
     * @return a CompletableFuture containing the updated project member
     */
    public CompletableFuture<ProjectMember> updateAsync(int memberId, MemberUpdateRequest request) {
        return updateAsync(memberId, request, null);
    }
    
    /**
     * Updates a project member with options asynchronously.
     * 
     * @param memberId the member ID
     * @param request the member update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated project member
     */
    public CompletableFuture<ProjectMember> updateAsync(int memberId, MemberUpdateRequest request, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        return httpClient.putAsync(path, request, ProjectMember.class);
    }
    
    /**
     * Deletes a project member.
     * 
     * @param memberId the member ID to delete
     */
    public void delete(int memberId) {
        delete(memberId, null);
    }
    
    /**
     * Deletes a project member with options.
     * 
     * @param memberId the member ID to delete
     * @param requestOptions request options
     */
    public void delete(int memberId, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        httpClient.delete(path, Void.class);
    }
    
    /**
     * Deletes a project member asynchronously.
     * 
     * @param memberId the member ID to delete
     * @return a CompletableFuture that completes when the member is deleted
     */
    public CompletableFuture<Void> deleteAsync(int memberId) {
        return deleteAsync(memberId, null);
    }
    
    /**
     * Deletes a project member with options asynchronously.
     * 
     * @param memberId the member ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the member is deleted
     */
    public CompletableFuture<Void> deleteAsync(int memberId, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/members/" + memberId + "/";
        return httpClient.deleteAsync(path, Void.class);
    }
    
    /**
     * Gets the project ID this client is associated with.
     * 
     * @return the project ID
     */
    public int getProjectId() {
        return projectId;
    }
}