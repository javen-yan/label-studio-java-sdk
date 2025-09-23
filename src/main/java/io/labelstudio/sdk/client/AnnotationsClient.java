package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Annotation;

/**
 * Client for managing Label Studio annotations.
 */
public class AnnotationsClient {
    
    private final HttpClient httpClient;
    
    public AnnotationsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    public Pagination<Annotation> list() {
        return httpClient.get("/api/annotations/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Annotation.class));
    }
    
    public Annotation get(int id) {
        return httpClient.get("/api/annotations/" + id + "/", Annotation.class);
    }
    
    public Annotation create(AnnotationCreateRequest request) {
        return httpClient.post("/api/annotations/", request, Annotation.class);
    }
    
    public Annotation update(int id, AnnotationUpdateRequest request) {
        return httpClient.put("/api/annotations/" + id + "/", request, Annotation.class);
    }
    
    public void delete(int id) {
        httpClient.delete("/api/annotations/" + id + "/", Void.class);
    }
}