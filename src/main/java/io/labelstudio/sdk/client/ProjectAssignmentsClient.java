package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Assignment;
import io.labelstudio.sdk.vo.AssignmentCreateRequest;
import io.labelstudio.sdk.vo.AssignmentUpdateRequest;
import io.labelstudio.sdk.vo.BulkAssignmentRequest;
import io.labelstudio.sdk.vo.BulkAssignmentResult;
import io.labelstudio.sdk.vo.BulkUnassignmentRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing task assignments in Label Studio projects.
 * 
 * <p>This client provides functionality to assign tasks to specific annotators,
 * manage assignment rules, and track assignment progress.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * Assignment assignment = client.projects().assignments(projectId).create(
 *     AssignmentCreateRequest.builder()
 *         .taskId(taskId)
 *         .userId(userId)
 *         .build()
 * );
 * </pre>
 */
public class ProjectAssignmentsClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    public ProjectAssignmentsClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Lists all assignments for the project.
     * 
     * @return a paginated list of assignments
     */
    public Pagination<Assignment> list() {
        return httpClient.getPaginated("/api/projects/" + projectId + "/assignments/", Assignment.class);
    }
    
    /**
     * Lists all assignments for the project asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of assignments
     */
    public CompletableFuture<Pagination<Assignment>> listAsync() {
        return httpClient.getPaginatedAsync("/api/projects/" + projectId + "/assignments/", Assignment.class);
    }
    
    /**
     * Creates a new assignment.
     * 
     * @param request the assignment creation request
     * @return the created assignment
     */
    public Assignment create(AssignmentCreateRequest request) {
        return httpClient.post("/api/projects/" + projectId + "/assignments/", request, Assignment.class);
    }
    
    /**
     * Creates a new assignment asynchronously.
     * 
     * @param request the assignment creation request
     * @return a CompletableFuture containing the created assignment
     */
    public CompletableFuture<Assignment> createAsync(AssignmentCreateRequest request) {
        return httpClient.postAsync("/api/projects/" + projectId + "/assignments/", request, Assignment.class);
    }
    
    /**
     * Gets a specific assignment by ID.
     * 
     * @param assignmentId the assignment ID
     * @return the assignment
     */
    public Assignment get(int assignmentId) {
        return httpClient.get("/api/projects/" + projectId + "/assignments/" + assignmentId + "/", Assignment.class);
    }
    
    /**
     * Gets a specific assignment by ID asynchronously.
     * 
     * @param assignmentId the assignment ID
     * @return a CompletableFuture containing the assignment
     */
    public CompletableFuture<Assignment> getAsync(int assignmentId) {
        return httpClient.getAsync("/api/projects/" + projectId + "/assignments/" + assignmentId + "/", Assignment.class);
    }
    
    /**
     * Updates an assignment.
     * 
     * @param assignmentId the assignment ID
     * @param request the assignment update request
     * @return the updated assignment
     */
    public Assignment update(int assignmentId, AssignmentUpdateRequest request) {
        return httpClient.patch("/api/projects/" + projectId + "/assignments/" + assignmentId + "/", request, Assignment.class);
    }
    
    /**
     * Updates an assignment asynchronously.
     * 
     * @param assignmentId the assignment ID
     * @param request the assignment update request
     * @return a CompletableFuture containing the updated assignment
     */
    public CompletableFuture<Assignment> updateAsync(int assignmentId, AssignmentUpdateRequest request) {
        return httpClient.patchAsync("/api/projects/" + projectId + "/assignments/" + assignmentId + "/", request, Assignment.class);
    }
    
    /**
     * Deletes an assignment.
     * 
     * @param assignmentId the assignment ID
     */
    public void delete(int assignmentId) {
        httpClient.delete("/api/projects/" + projectId + "/assignments/" + assignmentId + "/");
    }
    
    /**
     * Deletes an assignment asynchronously.
     * 
     * @param assignmentId the assignment ID
     * @return a CompletableFuture that completes when the assignment is deleted
     */
    public CompletableFuture<Void> deleteAsync(int assignmentId) {
        return httpClient.deleteAsync("/api/projects/" + projectId + "/assignments/" + assignmentId + "/");
    }
    
    /**
     * Assigns multiple tasks to a user.
     * 
     * @param request the bulk assignment request
     * @return the result of the bulk assignment operation
     */
    public BulkAssignmentResult bulkAssign(BulkAssignmentRequest request) {
        return httpClient.post("/api/projects/" + projectId + "/assignments/bulk/", request, BulkAssignmentResult.class);
    }
    
    /**
     * Assigns multiple tasks to a user asynchronously.
     * 
     * @param request the bulk assignment request
     * @return a CompletableFuture containing the result of the bulk assignment operation
     */
    public CompletableFuture<BulkAssignmentResult> bulkAssignAsync(BulkAssignmentRequest request) {
        return httpClient.postAsync("/api/projects/" + projectId + "/assignments/bulk/", request, BulkAssignmentResult.class);
    }
    
    /**
     * Unassigns multiple tasks from users.
     * 
     * @param request the bulk unassignment request
     * @return the result of the bulk unassignment operation
     */
    public BulkAssignmentResult bulkUnassign(BulkUnassignmentRequest request) {
        return httpClient.post("/api/projects/" + projectId + "/assignments/bulk-unassign/", request, BulkAssignmentResult.class);
    }
    
    /**
     * Unassigns multiple tasks from users asynchronously.
     * 
     * @param request the bulk unassignment request
     * @return a CompletableFuture containing the result of the bulk unassignment operation
     */
    public CompletableFuture<BulkAssignmentResult> bulkUnassignAsync(BulkUnassignmentRequest request) {
        return httpClient.postAsync("/api/projects/" + projectId + "/assignments/bulk-unassign/", request, BulkAssignmentResult.class);
    }
    
    /**
     * Gets assignments for a specific user.
     * 
     * @param userId the user ID
     * @return a paginated list of assignments for the user
     */
    public Pagination<Assignment> getByUser(int userId) {
        return httpClient.getPaginated("/api/projects/" + projectId + "/assignments/?user=" + userId, Assignment.class);
    }
    
    /**
     * Gets assignments for a specific user asynchronously.
     * 
     * @param userId the user ID
     * @return a CompletableFuture containing a paginated list of assignments for the user
     */
    public CompletableFuture<Pagination<Assignment>> getByUserAsync(int userId) {
        return httpClient.getPaginatedAsync("/api/projects/" + projectId + "/assignments/?user=" + userId, Assignment.class);
    }
    
    /**
     * Gets assignments for a specific task.
     * 
     * @param taskId the task ID
     * @return a paginated list of assignments for the task
     */
    public Pagination<Assignment> getByTask(int taskId) {
        return httpClient.getPaginated("/api/projects/" + projectId + "/assignments/?task=" + taskId, Assignment.class);
    }
    
    /**
     * Gets assignments for a specific task asynchronously.
     * 
     * @param taskId the task ID
     * @return a CompletableFuture containing a paginated list of assignments for the task
     */
    public CompletableFuture<Pagination<Assignment>> getByTaskAsync(int taskId) {
        return httpClient.getPaginatedAsync("/api/projects/" + projectId + "/assignments/?task=" + taskId, Assignment.class);
    }
}