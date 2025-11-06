package io.labelstudio.sdk;

import io.labelstudio.sdk.client.MemberCreateRequest;
import io.labelstudio.sdk.client.MemberUpdateRequest;
import io.labelstudio.sdk.client.ProjectMembersClient;
import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.ProjectMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Test class for ProjectMembersClient functionality.
 */
public class ProjectMembersTest {
    
    @Mock
    private HttpClient httpClient;
    
    private ProjectMembersClient membersClient;
    private final int projectId = 123;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        membersClient = new ProjectMembersClient(httpClient, projectId);
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testList() {
        // Given
        Pagination<ProjectMember> expectedMembers = new Pagination<>();
        when(httpClient.get(eq("/api/projects/123/members/"), any(Class.class))).thenReturn(expectedMembers);
        
        // When
        Pagination<ProjectMember> result = membersClient.list();
        
        // Then
        assertSame(expectedMembers, result);
        verify(httpClient).get("/api/projects/123/members/", httpClient.getObjectMapper().getTypeFactory()
                .constructParametricType(Pagination.class, ProjectMember.class));
    }
    
    @Test
    public void testCreate() {
        // Given
        MemberCreateRequest request = MemberCreateRequest.builder()
                .userId(456)
                .annotator()
                .enabled()
                .build();
        ProjectMember expectedMember = new ProjectMember();
        when(httpClient.post(eq("/api/projects/123/members/"), eq(request), eq(ProjectMember.class)))
                .thenReturn(expectedMember);
        
        // When
        ProjectMember result = membersClient.create(request);
        
        // Then
        assertSame(expectedMember, result);
        verify(httpClient).post("/api/projects/123/members/", request, ProjectMember.class);
    }
    
    @Test
    public void testGet() {
        // Given
        int memberId = 789;
        ProjectMember expectedMember = new ProjectMember();
        when(httpClient.get(eq("/api/projects/123/members/789/"), eq(ProjectMember.class)))
                .thenReturn(expectedMember);
        
        // When
        ProjectMember result = membersClient.get(memberId);
        
        // Then
        assertSame(expectedMember, result);
        verify(httpClient).get("/api/projects/123/members/789/", ProjectMember.class);
    }
    
    @Test
    public void testUpdate() {
        // Given
        int memberId = 789;
        MemberUpdateRequest request = MemberUpdateRequest.builder()
                .reviewer()
                .build();
        ProjectMember expectedMember = new ProjectMember();
        when(httpClient.put(eq("/api/projects/123/members/789/"), eq(request), eq(ProjectMember.class)))
                .thenReturn(expectedMember);
        
        // When
        ProjectMember result = membersClient.update(memberId, request);
        
        // Then
        assertSame(expectedMember, result);
        verify(httpClient).put("/api/projects/123/members/789/", request, ProjectMember.class);
    }
    
    @Test
    public void testDelete() {
        // Given
        int memberId = 789;
        
        // When
        membersClient.delete(memberId);
        
        // Then
        verify(httpClient).delete("/api/projects/123/members/789/", Void.class);
    }
    
    @Test
    public void testMemberCreateRequestBuilder() {
        // When
        MemberCreateRequest request = MemberCreateRequest.builder()
                .userId(123)
                .annotator()
                .enabled()
                .build();
        
        // Then
        assertEquals(Integer.valueOf(123), request.getUserId());
        assertEquals("annotator", request.getRole());
        assertTrue(request.getEnabled());
    }
    
    @Test
    public void testMemberUpdateRequestBuilder() {
        // When
        MemberUpdateRequest request = MemberUpdateRequest.builder()
                .manager()
                .disabled()
                .build();
        
        // Then
        assertEquals("manager", request.getRole());
        assertFalse(request.getEnabled());
    }
    
    @Test
    public void testGetProjectId() {
        // Then
        assertEquals(projectId, membersClient.getProjectId());
    }
}