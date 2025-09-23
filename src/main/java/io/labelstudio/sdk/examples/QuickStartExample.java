package io.labelstudio.sdk.examples;

import io.labelstudio.sdk.LabelStudio;
import io.labelstudio.sdk.client.AnnotationCreateRequest;
import io.labelstudio.sdk.client.ProjectCreateRequest;
import io.labelstudio.sdk.client.TaskCreateRequest;
import io.labelstudio.sdk.core.ApiError;
import io.labelstudio.sdk.core.LabelStudioEnvironment;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Annotation;
import io.labelstudio.sdk.models.Project;
import io.labelstudio.sdk.models.Task;
import io.labelstudio.sdk.models.UserSimple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Quick start example demonstrating basic Label Studio SDK usage.
 * 
 * <p>To run this example:</p>
 * <ol>
 *   <li>Start a Label Studio instance (e.g., docker run -it -p 8080:8080 heartexlabs/label-studio:latest)</li>
 *   <li>Create an API token in the Label Studio UI</li>
 *   <li>Set the LABEL_STUDIO_API_KEY environment variable or modify the code below</li>
 *   <li>Run this class</li>
 * </ol>
 */
public class QuickStartExample {
    
    public static void main(String[] args) {
        try {
            // Create Label Studio client
            LabelStudio client = LabelStudio.builder()
                    .environment(LabelStudioEnvironment.DEFAULT) // http://localhost:8080
                    .apiKey(System.getenv("LABEL_STUDIO_API_KEY")) // Set this environment variable
                    .build();
            
            System.out.println("=== Label Studio Java SDK Quick Start Example ===\n");
            
            // 1. Check current user
            System.out.println("1. Getting current user info...");
            UserSimple currentUser = client.users().whoami();
            System.out.println("   Current user: " + currentUser.getUsername() + " (" + currentUser.getEmail() + ")\n");
            
            // 2. Create a project
            System.out.println("2. Creating a new project...");
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
            
            ProjectCreateRequest projectRequest = ProjectCreateRequest.builder()
                    .title("SDK Example: Sentiment Analysis")
                    .description("A demonstration project created by the Java SDK")
                    .labelConfig(labelConfig)
                    .showInstruction(true)
                    .enableEmptyAnnotation(false)
                    .maximumAnnotations(1)
                    .build();
            
            Project project = client.projects().create(projectRequest);
            System.out.println("   Created project: " + project.getTitle() + " (ID: " + project.getId() + ")\n");
            
            // 3. Validate label configuration
            System.out.println("3. Validating label configuration...");
            var validation = client.projects().validateLabelConfig(project.getId(), labelConfig);
            if (validation.isValid()) {
                System.out.println("   ✓ Label configuration is valid\n");
            } else {
                System.out.println("   ✗ Label configuration has errors: " + validation.getErrors() + "\n");
            }
            
            // 4. Import tasks
            System.out.println("4. Creating tasks...");
            List<Map<String, Object>> taskData = Arrays.asList(
                    Map.of("text", "I absolutely love this new product! It's amazing!"),
                    Map.of("text", "This is the worst thing I've ever bought. Terrible quality."),
                    Map.of("text", "It's okay, nothing special. Average quality for the price."),
                    Map.of("text", "Fantastic customer service and quick delivery!"),
                    Map.of("text", "Completely useless. I want my money back.")
            );
            
            // Create tasks one by one (alternatively, you could use importTasks for bulk import)
            for (int i = 0; i < taskData.size(); i++) {
                TaskCreateRequest taskRequest = TaskCreateRequest.builder()
                        .data(taskData.get(i))
                        .project(project.getId())
                        .build();
                
                Task task = client.tasks().create(project.getId(), taskRequest);
                System.out.println("   Created task " + (i + 1) + ": " + task.getData().get("text"));
            }
            System.out.println();
            
            // 5. List tasks
            System.out.println("5. Listing all tasks in the project...");
            Pagination<Task> tasks = client.tasks().list(project.getId());
            System.out.println("   Found " + tasks.getCount() + " tasks:");
            for (Task task : tasks.getResults()) {
                System.out.println("   - Task " + task.getId() + ": " + task.getData().get("text"));
                System.out.println("     Labeled: " + (task.getIsLabeled() != null ? task.getIsLabeled() : false));
            }
            System.out.println();
            
            // 6. Create an annotation for the first task
            if (!tasks.getResults().isEmpty()) {
                System.out.println("6. Creating an annotation for the first task...");
                Task firstTask = tasks.getResults().get(0);
                
                List<Map<String, Object>> annotationResult = Arrays.asList(
                        Map.of(
                                "from_name", "sentiment",
                                "to_name", "text",
                                "type", "choices",
                                "value", Map.of("choices", Arrays.asList("Positive"))
                        )
                );
                
                AnnotationCreateRequest annotationRequest = AnnotationCreateRequest.builder()
                        .task(firstTask.getId())
                        .result(annotationResult)
                        .leadTime(5.0) // 5 seconds
                        .build();
                
                Annotation annotation = client.annotations().create(annotationRequest);
                System.out.println("   Created annotation " + annotation.getId() + " for task " + firstTask.getId());
                System.out.println("   Annotation result: " + annotation.getResult() + "\n");
            }
            
            // 7. List projects to verify everything was created
            System.out.println("7. Listing all projects...");
            Pagination<Project> projects = client.projects().list();
            System.out.println("   Total projects: " + projects.getCount());
            for (Project p : projects.getResults()) {
                System.out.println("   - " + p.getTitle() + " (ID: " + p.getId() + ", Tasks: " + p.getTaskNumber() + ")");
            }
            System.out.println();
            
            // 8. Cleanup (optional - remove the created project)
            System.out.println("8. Cleaning up...");
            System.out.println("   To clean up, you can delete the project with ID: " + project.getId());
            System.out.println("   Uncomment the line below to automatically delete the project:");
            // client.projects().delete(project.getId());
            // System.out.println("   ✓ Project deleted");
            
            System.out.println("\n=== Example completed successfully! ===");
            
        } catch (ApiError e) {
            System.err.println("API Error: " + e.getMessage());
            System.err.println("Status Code: " + e.getStatusCode());
            System.err.println("Response Body: " + e.getBody());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}