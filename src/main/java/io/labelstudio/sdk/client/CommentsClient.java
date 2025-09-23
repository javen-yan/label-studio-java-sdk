package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Comment;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing comments in Label Studio.
 * 
 * <p>This client provides functionality for creating, reading, updating,
 * and deleting comments on tasks and annotations.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * Comment comment = client.comments().create(
 *     CommentCreateRequest.builder()
 *         .taskId(taskId)
 *         .text("This is a comment")
 *         .build()
 * );
 * </pre>
 */
public class CommentsClient {
    
    private final HttpClient httpClient;
    
    public CommentsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all comments.
     * 
     * @return a paginated list of comments
     */
    public Pagination<Comment> list() {
        return httpClient.getPaginated("/api/comments/", Comment.class);
    }
    
    /**
     * Lists all comments asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of comments
     */
    public CompletableFuture<Pagination<Comment>> listAsync() {
        return httpClient.getPaginatedAsync("/api/comments/", Comment.class);
    }
    
    /**
     * Creates a new comment.
     * 
     * @param request the comment creation request
     * @return the created comment
     */
    public Comment create(CommentCreateRequest request) {
        return httpClient.post("/api/comments/", request, Comment.class);
    }
    
    /**
     * Creates a new comment asynchronously.
     * 
     * @param request the comment creation request
     * @return a CompletableFuture containing the created comment
     */
    public CompletableFuture<Comment> createAsync(CommentCreateRequest request) {
        return httpClient.postAsync("/api/comments/", request, Comment.class);
    }
    
    /**
     * Gets a specific comment by ID.
     * 
     * @param commentId the comment ID
     * @return the comment
     */
    public Comment get(int commentId) {
        return httpClient.get("/api/comments/" + commentId + "/", Comment.class);
    }
    
    /**
     * Gets a specific comment by ID asynchronously.
     * 
     * @param commentId the comment ID
     * @return a CompletableFuture containing the comment
     */
    public CompletableFuture<Comment> getAsync(int commentId) {
        return httpClient.getAsync("/api/comments/" + commentId + "/", Comment.class);
    }
    
    /**
     * Updates a comment.
     * 
     * @param commentId the comment ID
     * @param request the comment update request
     * @return the updated comment
     */
    public Comment update(int commentId, CommentUpdateRequest request) {
        return httpClient.patch("/api/comments/" + commentId + "/", request, Comment.class);
    }
    
    /**
     * Updates a comment asynchronously.
     * 
     * @param commentId the comment ID
     * @param request the comment update request
     * @return a CompletableFuture containing the updated comment
     */
    public CompletableFuture<Comment> updateAsync(int commentId, CommentUpdateRequest request) {
        return httpClient.patchAsync("/api/comments/" + commentId + "/", request, Comment.class);
    }
    
    /**
     * Deletes a comment.
     * 
     * @param commentId the comment ID
     */
    public void delete(int commentId) {
        httpClient.delete("/api/comments/" + commentId + "/");
    }
    
    /**
     * Deletes a comment asynchronously.
     * 
     * @param commentId the comment ID
     * @return a CompletableFuture that completes when the comment is deleted
     */
    public CompletableFuture<Void> deleteAsync(int commentId) {
        return httpClient.deleteAsync("/api/comments/" + commentId + "/");
    }
    
    /**
     * Lists comments for a specific task.
     * 
     * @param taskId the task ID
     * @return a paginated list of comments for the task
     */
    public Pagination<Comment> listByTask(int taskId) {
        return httpClient.getPaginated("/api/comments/?task=" + taskId, Comment.class);
    }
    
    /**
     * Lists comments for a specific task asynchronously.
     * 
     * @param taskId the task ID
     * @return a CompletableFuture containing a paginated list of comments for the task
     */
    public CompletableFuture<Pagination<Comment>> listByTaskAsync(int taskId) {
        return httpClient.getPaginatedAsync("/api/comments/?task=" + taskId, Comment.class);
    }
    
    /**
     * Lists comments for a specific annotation.
     * 
     * @param annotationId the annotation ID
     * @return a paginated list of comments for the annotation
     */
    public Pagination<Comment> listByAnnotation(int annotationId) {
        return httpClient.getPaginated("/api/comments/?annotation=" + annotationId, Comment.class);
    }
    
    /**
     * Lists comments for a specific annotation asynchronously.
     * 
     * @param annotationId the annotation ID
     * @return a CompletableFuture containing a paginated list of comments for the annotation
     */
    public CompletableFuture<Pagination<Comment>> listByAnnotationAsync(int annotationId) {
        return httpClient.getPaginatedAsync("/api/comments/?annotation=" + annotationId, Comment.class);
    }
    
    /**
     * Lists comments by a specific user.
     * 
     * @param userId the user ID
     * @return a paginated list of comments by the user
     */
    public Pagination<Comment> listByUser(int userId) {
        return httpClient.getPaginated("/api/comments/?user=" + userId, Comment.class);
    }
    
    /**
     * Lists comments by a specific user asynchronously.
     * 
     * @param userId the user ID
     * @return a CompletableFuture containing a paginated list of comments by the user
     */
    public CompletableFuture<Pagination<Comment>> listByUserAsync(int userId) {
        return httpClient.getPaginatedAsync("/api/comments/?user=" + userId, Comment.class);
    }
    
    /**
     * Lists comments for a specific project.
     * 
     * @param projectId the project ID
     * @return a paginated list of comments for the project
     */
    public Pagination<Comment> listByProject(int projectId) {
        return httpClient.getPaginated("/api/comments/?project=" + projectId, Comment.class);
    }
    
    /**
     * Lists comments for a specific project asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture containing a paginated list of comments for the project
     */
    public CompletableFuture<Pagination<Comment>> listByProjectAsync(int projectId) {
        return httpClient.getPaginatedAsync("/api/comments/?project=" + projectId, Comment.class);
    }
}