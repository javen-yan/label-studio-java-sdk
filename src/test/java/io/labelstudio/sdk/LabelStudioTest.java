package io.labelstudio.sdk;

import io.labelstudio.sdk.client.ProjectCreateRequest;
import io.labelstudio.sdk.core.LabelStudioEnvironment;
import io.labelstudio.sdk.models.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Label Studio SDK.
 */
public class LabelStudioTest {
    
    private LabelStudio client;
    
    @BeforeEach
    public void setUp() {
        // Note: These tests require a running Label Studio instance and valid API key
        // For unit testing, you would typically use mock servers
        client = LabelStudio.builder()
                .environment(LabelStudioEnvironment.DEFAULT)
                .apiKey("test-api-key") // This should be a real API key for integration tests
                .build();
    }
    
    @Test
    public void testClientCreation() {
        assertNotNull(client);
        assertNotNull(client.projects());
        assertNotNull(client.tasks());
        assertNotNull(client.annotations());
        assertNotNull(client.users());
    }
    
    @Test
    public void testProjectCreateRequestBuilder() {
        String labelConfig = """
                <View>
                  <Header value="Choose text sentiment:"/>
                  <Text name="text" value="$text"/>
                  <Choices name="sentiment" toName="text" choice="single">
                    <Choice value="Positive"/>
                    <Choice value="Negative"/>
                    <Choice value="Neutral"/>
                  </Choices>
                </View>
                """;
        
        ProjectCreateRequest request = ProjectCreateRequest.builder()
                .title("Test Project")
                .description("A test project for sentiment analysis")
                .labelConfig(labelConfig)
                .showInstruction(true)
                .enableEmptyAnnotation(false)
                .maximumAnnotations(1)
                .build();
        
        assertEquals("Test Project", request.getTitle());
        assertEquals("A test project for sentiment analysis", request.getDescription());
        assertEquals(labelConfig, request.getLabelConfig());
        assertTrue(request.getShowInstruction());
        assertFalse(request.getEnableEmptyAnnotation());
        assertEquals(1, request.getMaximumAnnotations());
    }
    
    @Test
    public void testBuilderWithEnvironment() {
        LabelStudio prodClient = LabelStudio.builder()
                .environment(LabelStudioEnvironment.PRODUCTION)
                .apiKey("test-key")
                .build();
        
        assertNotNull(prodClient);
    }
    
    @Test
    public void testBuilderWithBaseUrl() {
        LabelStudio customClient = LabelStudio.builder()
                .baseUrl("http://custom-label-studio.com")
                .apiKey("test-key")
                .build();
        
        assertNotNull(customClient);
    }
    
    // Integration test - uncomment and provide real credentials to test
    /*
    @Test
    public void testCreateProject() {
        String labelConfig = """
                <View>
                  <Text name="text" value="$text"/>
                  <Choices name="sentiment" toName="text" choice="single">
                    <Choice value="Positive"/>
                    <Choice value="Negative"/>
                  </Choices>
                </View>
                """;
        
        ProjectCreateRequest request = ProjectCreateRequest.builder()
                .title("SDK Test Project")
                .labelConfig(labelConfig)
                .build();
        
        Project project = client.projects().create(request);
        
        assertNotNull(project);
        assertNotNull(project.getId());
        assertEquals("SDK Test Project", project.getTitle());
        
        // Clean up
        client.projects().delete(project.getId());
    }
    */
}