package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.AnnotationReview;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing annotation reviews in Label Studio.
 * 
 * <p>This client provides functionality for reviewing annotations,
 * accepting/rejecting annotations, and managing the review process.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * AnnotationReview review = client.annotationReviews().create(
 *     ReviewCreateRequest.builder()
 *         .annotationId(annotationId)
 *         .action("accept")
 *         .build()
 * );
 * </pre>
 */
public class AnnotationReviewsClient {
    
    private final HttpClient httpClient;
    
    public AnnotationReviewsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all annotation reviews.
     * 
     * @return a paginated list of annotation reviews
     */
    public Pagination<AnnotationReview> list() {
        return httpClient.getPaginated("/api/annotation-reviews/", AnnotationReview.class);
    }
    
    /**
     * Lists all annotation reviews asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of annotation reviews
     */
    public CompletableFuture<Pagination<AnnotationReview>> listAsync() {
        return httpClient.getPaginatedAsync("/api/annotation-reviews/", AnnotationReview.class);
    }
    
    /**
     * Creates a new annotation review.
     * 
     * @param request the review creation request
     * @return the created review
     */
    public AnnotationReview create(ReviewCreateRequest request) {
        return httpClient.post("/api/annotation-reviews/", request, AnnotationReview.class);
    }
    
    /**
     * Creates a new annotation review asynchronously.
     * 
     * @param request the review creation request
     * @return a CompletableFuture containing the created review
     */
    public CompletableFuture<AnnotationReview> createAsync(ReviewCreateRequest request) {
        return httpClient.postAsync("/api/annotation-reviews/", request, AnnotationReview.class);
    }
    
    /**
     * Gets a specific annotation review by ID.
     * 
     * @param reviewId the review ID
     * @return the annotation review
     */
    public AnnotationReview get(int reviewId) {
        return httpClient.get("/api/annotation-reviews/" + reviewId + "/", AnnotationReview.class);
    }
    
    /**
     * Gets a specific annotation review by ID asynchronously.
     * 
     * @param reviewId the review ID
     * @return a CompletableFuture containing the annotation review
     */
    public CompletableFuture<AnnotationReview> getAsync(int reviewId) {
        return httpClient.getAsync("/api/annotation-reviews/" + reviewId + "/", AnnotationReview.class);
    }
    
    /**
     * Updates an annotation review.
     * 
     * @param reviewId the review ID
     * @param request the review update request
     * @return the updated review
     */
    public AnnotationReview update(int reviewId, ReviewUpdateRequest request) {
        return httpClient.patch("/api/annotation-reviews/" + reviewId + "/", request, AnnotationReview.class);
    }
    
    /**
     * Updates an annotation review asynchronously.
     * 
     * @param reviewId the review ID
     * @param request the review update request
     * @return a CompletableFuture containing the updated review
     */
    public CompletableFuture<AnnotationReview> updateAsync(int reviewId, ReviewUpdateRequest request) {
        return httpClient.patchAsync("/api/annotation-reviews/" + reviewId + "/", request, AnnotationReview.class);
    }
    
    /**
     * Deletes an annotation review.
     * 
     * @param reviewId the review ID
     */
    public void delete(int reviewId) {
        httpClient.delete("/api/annotation-reviews/" + reviewId + "/");
    }
    
    /**
     * Deletes an annotation review asynchronously.
     * 
     * @param reviewId the review ID
     * @return a CompletableFuture that completes when the review is deleted
     */
    public CompletableFuture<Void> deleteAsync(int reviewId) {
        return httpClient.deleteAsync("/api/annotation-reviews/" + reviewId + "/");
    }
    
    /**
     * Lists reviews for a specific annotation.
     * 
     * @param annotationId the annotation ID
     * @return a paginated list of reviews for the annotation
     */
    public Pagination<AnnotationReview> listByAnnotation(int annotationId) {
        return httpClient.getPaginated("/api/annotation-reviews/?annotation=" + annotationId, AnnotationReview.class);
    }
    
    /**
     * Lists reviews for a specific annotation asynchronously.
     * 
     * @param annotationId the annotation ID
     * @return a CompletableFuture containing a paginated list of reviews for the annotation
     */
    public CompletableFuture<Pagination<AnnotationReview>> listByAnnotationAsync(int annotationId) {
        return httpClient.getPaginatedAsync("/api/annotation-reviews/?annotation=" + annotationId, AnnotationReview.class);
    }
    
    /**
     * Lists reviews by a specific reviewer.
     * 
     * @param reviewerId the reviewer user ID
     * @return a paginated list of reviews by the reviewer
     */
    public Pagination<AnnotationReview> listByReviewer(int reviewerId) {
        return httpClient.getPaginated("/api/annotation-reviews/?reviewer=" + reviewerId, AnnotationReview.class);
    }
    
    /**
     * Lists reviews by a specific reviewer asynchronously.
     * 
     * @param reviewerId the reviewer user ID
     * @return a CompletableFuture containing a paginated list of reviews by the reviewer
     */
    public CompletableFuture<Pagination<AnnotationReview>> listByReviewerAsync(int reviewerId) {
        return httpClient.getPaginatedAsync("/api/annotation-reviews/?reviewer=" + reviewerId, AnnotationReview.class);
    }
    
    /**
     * Accepts an annotation.
     * 
     * @param annotationId the annotation ID
     * @param comment optional comment
     * @return the created review
     */
    public AnnotationReview accept(int annotationId, String comment) {
        return create(ReviewCreateRequest.builder()
            .annotationId(annotationId)
            .accept()
            .comment(comment)
            .build());
    }
    
    /**
     * Accepts an annotation asynchronously.
     * 
     * @param annotationId the annotation ID
     * @param comment optional comment
     * @return a CompletableFuture containing the created review
     */
    public CompletableFuture<AnnotationReview> acceptAsync(int annotationId, String comment) {
        return createAsync(ReviewCreateRequest.builder()
            .annotationId(annotationId)
            .accept()
            .comment(comment)
            .build());
    }
    
    /**
     * Rejects an annotation.
     * 
     * @param annotationId the annotation ID
     * @param comment optional comment
     * @return the created review
     */
    public AnnotationReview reject(int annotationId, String comment) {
        return create(ReviewCreateRequest.builder()
            .annotationId(annotationId)
            .reject()
            .comment(comment)
            .build());
    }
    
    /**
     * Rejects an annotation asynchronously.
     * 
     * @param annotationId the annotation ID
     * @param comment optional comment
     * @return a CompletableFuture containing the created review
     */
    public CompletableFuture<AnnotationReview> rejectAsync(int annotationId, String comment) {
        return createAsync(ReviewCreateRequest.builder()
            .annotationId(annotationId)
            .reject()
            .comment(comment)
            .build());
    }
}