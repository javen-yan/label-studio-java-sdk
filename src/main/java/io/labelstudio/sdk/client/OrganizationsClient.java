package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Organization;
import io.labelstudio.sdk.vo.OrganizationCreateRequest;
import io.labelstudio.sdk.vo.OrganizationUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio organizations.
 * 
 * <p>This client provides methods to manage organization configurations,
 * allowing you to create and manage multi-tenant Label Studio deployments
 * with separate workspaces for different teams or clients.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * // Create a new organization
 * Organization org = client.organizations().create(
 *     OrganizationCreateRequest.builder()
 *         .title("Acme Corporation")
 *         .description("Data annotation team for Acme Corp")
 *         .build()
 * );
 * 
 * // Get organization details
 * Organization details = client.organizations().get(org.getId());
 * </pre>
 */
public class OrganizationsClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new organizations client.
     * 
     * @param httpClient the HTTP client to use
     */
    public OrganizationsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all organizations.
     * 
     * @return a paginated list of organizations
     */
    public Pagination<Organization> list() {
        return list(null);
    }
    
    /**
     * Lists all organizations with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of organizations
     */
    public Pagination<Organization> list(RequestOptions requestOptions) {
        return httpClient.getPaginated("/api/organizations/", Organization.class);
    }
    
    /**
     * Lists all organizations asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of organizations
     */
    public CompletableFuture<Pagination<Organization>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all organizations with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of organizations
     */
    public CompletableFuture<Pagination<Organization>> listAsync(RequestOptions requestOptions) {
        return httpClient.getPaginatedAsync("/api/organizations/", Organization.class);
    }
    
    /**
     * Creates a new organization.
     * 
     * @param request the organization creation request
     * @return the created organization
     */
    public Organization create(OrganizationCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new organization with options.
     * 
     * @param request the organization creation request
     * @param requestOptions request options
     * @return the created organization
     */
    public Organization create(OrganizationCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/organizations/", request, Organization.class);
    }
    
    /**
     * Creates a new organization asynchronously.
     * 
     * @param request the organization creation request
     * @return a CompletableFuture containing the created organization
     */
    public CompletableFuture<Organization> createAsync(OrganizationCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new organization with options asynchronously.
     * 
     * @param request the organization creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created organization
     */
    public CompletableFuture<Organization> createAsync(OrganizationCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/organizations/", request, Organization.class);
    }
    
    /**
     * Gets an organization by ID.
     * 
     * @param organizationId the organization ID
     * @return the organization
     */
    public Organization get(int organizationId) {
        return get(organizationId, null);
    }
    
    /**
     * Gets an organization by ID with options.
     * 
     * @param organizationId the organization ID
     * @param requestOptions request options
     * @return the organization
     */
    public Organization get(int organizationId, RequestOptions requestOptions) {
        return httpClient.get("/api/organizations/" + organizationId + "/", Organization.class);
    }
    
    /**
     * Gets an organization by ID asynchronously.
     * 
     * @param organizationId the organization ID
     * @return a CompletableFuture containing the organization
     */
    public CompletableFuture<Organization> getAsync(int organizationId) {
        return getAsync(organizationId, null);
    }
    
    /**
     * Gets an organization by ID with options asynchronously.
     * 
     * @param organizationId the organization ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the organization
     */
    public CompletableFuture<Organization> getAsync(int organizationId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/organizations/" + organizationId + "/", Organization.class);
    }
    
    /**
     * Updates an organization.
     * 
     * @param organizationId the organization ID
     * @param request the organization update request
     * @return the updated organization
     */
    public Organization update(int organizationId, OrganizationUpdateRequest request) {
        return update(organizationId, request, null);
    }
    
    /**
     * Updates an organization with options.
     * 
     * @param organizationId the organization ID
     * @param request the organization update request
     * @param requestOptions request options
     * @return the updated organization
     */
    public Organization update(int organizationId, OrganizationUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.put("/api/organizations/" + organizationId + "/", request, Organization.class);
    }
    
    /**
     * Updates an organization asynchronously.
     * 
     * @param organizationId the organization ID
     * @param request the organization update request
     * @return a CompletableFuture containing the updated organization
     */
    public CompletableFuture<Organization> updateAsync(int organizationId, OrganizationUpdateRequest request) {
        return updateAsync(organizationId, request, null);
    }
    
    /**
     * Updates an organization with options asynchronously.
     * 
     * @param organizationId the organization ID
     * @param request the organization update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated organization
     */
    public CompletableFuture<Organization> updateAsync(int organizationId, OrganizationUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.putAsync("/api/organizations/" + organizationId + "/", request, Organization.class);
    }
    
    /**
     * Deletes an organization.
     * 
     * @param organizationId the organization ID to delete
     */
    public void delete(int organizationId) {
        delete(organizationId, null);
    }
    
    /**
     * Deletes an organization with options.
     * 
     * @param organizationId the organization ID to delete
     * @param requestOptions request options
     */
    public void delete(int organizationId, RequestOptions requestOptions) {
        httpClient.delete("/api/organizations/" + organizationId + "/", Void.class);
    }
    
    /**
     * Deletes an organization asynchronously.
     * 
     * @param organizationId the organization ID to delete
     * @return a CompletableFuture that completes when the organization is deleted
     */
    public CompletableFuture<Void> deleteAsync(int organizationId) {
        return deleteAsync(organizationId, null);
    }
    
    /**
     * Deletes an organization with options asynchronously.
     * 
     * @param organizationId the organization ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the organization is deleted
     */
    public CompletableFuture<Void> deleteAsync(int organizationId, RequestOptions requestOptions) {
        return httpClient.deleteAsync("/api/organizations/" + organizationId + "/", Void.class);
    }
    
    /**
     * Gets the current user's organization membership information.
     * 
     * @return the current organization
     */
    public Organization getCurrent() {
        return getCurrent(null);
    }
    
    /**
     * Gets the current user's organization membership information with options.
     * 
     * @param requestOptions request options
     * @return the current organization
     */
    public Organization getCurrent(RequestOptions requestOptions) {
        return httpClient.get("/api/organizations/current/", Organization.class);
    }
    
    /**
     * Gets the current user's organization membership information asynchronously.
     * 
     * @return a CompletableFuture containing the current organization
     */
    public CompletableFuture<Organization> getCurrentAsync() {
        return getCurrentAsync(null);
    }
    
    /**
     * Gets the current user's organization membership information with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing the current organization
     */
    public CompletableFuture<Organization> getCurrentAsync(RequestOptions requestOptions) {
        return httpClient.getAsync("/api/organizations/current/", Organization.class);
    }
    
    /**
     * Switches the current user's active organization.
     * 
     * @param organizationId the organization ID to switch to
     * @return the updated organization
     */
    public Organization switchTo(int organizationId) {
        return switchTo(organizationId, null);
    }
    
    /**
     * Switches the current user's active organization with options.
     * 
     * @param organizationId the organization ID to switch to
     * @param requestOptions request options
     * @return the updated organization
     */
    public Organization switchTo(int organizationId, RequestOptions requestOptions) {
        return httpClient.post("/api/organizations/" + organizationId + "/switch/", null, Organization.class);
    }
    
    /**
     * Switches the current user's active organization asynchronously.
     * 
     * @param organizationId the organization ID to switch to
     * @return a CompletableFuture containing the updated organization
     */
    public CompletableFuture<Organization> switchToAsync(int organizationId) {
        return switchToAsync(organizationId, null);
    }
    
    /**
     * Switches the current user's active organization with options asynchronously.
     * 
     * @param organizationId the organization ID to switch to
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated organization
     */
    public CompletableFuture<Organization> switchToAsync(int organizationId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/organizations/" + organizationId + "/switch/", null, Organization.class);
    }
}