package io.labelstudio.sdk.examples;

import io.labelstudio.sdk.LabelStudio;
import io.labelstudio.sdk.vo.AnnotationCreateRequest;
import io.labelstudio.sdk.vo.ExportCreateRequest;
import io.labelstudio.sdk.vo.LabelConfigValidationResult;
import io.labelstudio.sdk.vo.ProjectCreateRequest;
import io.labelstudio.sdk.vo.ProjectsListOptions;
import io.labelstudio.sdk.vo.TaskCreateRequest;
import io.labelstudio.sdk.vo.TasksListOptions;
import io.labelstudio.sdk.core.ApiError;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Annotation;
import io.labelstudio.sdk.models.Export;
import io.labelstudio.sdk.models.Project;
import io.labelstudio.sdk.models.Task;
import io.labelstudio.sdk.models.UserSimple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(QuickStartExample.class);
    
    /**
     * Helper method to create a map with a single key-value pair (Java 8 compatible)
     */
    private static Map<String, Object> createMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
    
    public static void main(String[] args) {
        try {
            logger.info("=== Label Studio Java SDK Quick Start Example ===\n");
            
            LabelStudio client = null;

            String baseUrl = System.getenv("LABEL_STUDIO_BASE_URL");
            
            // ============================================================
            // 方式1: 直接使用 API Key 初始化客户端
            // ============================================================
            logger.info("方式1: 使用 API Key 初始化客户端");
            String apiKey = System.getenv("LABEL_STUDIO_API_KEY");
            if (apiKey != null && !apiKey.trim().isEmpty()) {
                LabelStudio client1 = LabelStudio.builder()
                        .baseUrl(baseUrl)
                        .apiKey(apiKey)
                        .build();
                logger.info("   ✓ 客户端已使用 API Key 初始化");
                // 如果方式2不可用，则使用方式1
                if (client == null) {
                    client = client1;
                }
            } else {
                logger.warn("   跳过方式1: 未设置 LABEL_STUDIO_API_KEY 环境变量");
            }
            logger.info("");
            
            // ============================================================
            // 方式2: 使用登录方式直接构建客户端
            // ============================================================
            logger.info("方式2: 使用登录方式直接构建客户端");
            String email = System.getenv("LABEL_STUDIO_EMAIL");
            String password = System.getenv("LABEL_STUDIO_PASSWORD");
            if (email != null && password != null) {
                // 直接使用 login 方法创建客户端（内部会自动处理登录和 token）
                client = LabelStudio.login(
                        baseUrl,
                        email,
                        password
                );
                logger.info("   ✓ 登录成功，客户端已创建（优先使用方式2）");
            } else {
                logger.warn("   跳过方式2: 请设置 LABEL_STUDIO_EMAIL 和 LABEL_STUDIO_PASSWORD 环境变量");
            }
            logger.info("");
            
            // 检查是否成功初始化了客户端
            if (client == null) {
                logger.error("错误: 无法初始化客户端。请使用方式1（设置 LABEL_STUDIO_API_KEY）或方式2（设置 LABEL_STUDIO_EMAIL 和 LABEL_STUDIO_PASSWORD）");
                return;
            }
            
            // 1. Check current user
            logger.info("1. Getting current user info...");
            UserSimple currentUser = client.users().whoami();
            logger.info("   Current user: " + currentUser.getUsername() + " (" + currentUser.getEmail() + ")\n");
            
            // 2. Create a project
            logger.info("2. Creating a new project...");
            String labelConfig = "<View>\n" +
                    "  <Header value=\"Choose text sentiment:\"/>\n" +
                    "  <Text name=\"text\" value=\"$text\"/>\n" +
                    "  <Choices name=\"sentiment\" toName=\"text\" choice=\"single\">\n" +
                    "    <Choice value=\"Positive\"/>\n" +
                    "    <Choice value=\"Negative\"/>\n" +
                    "    <Choice value=\"Neutral\"/>\n" +
                    "  </Choices>\n" +
                    "</View>";
            
            ProjectCreateRequest projectRequest = ProjectCreateRequest.builder()
                    .title("SDK Example: Sentiment Analysis")
                    .description("A demonstration project created by the Java SDK")
                    .labelConfig(labelConfig)
                    .showInstruction(true)
                    .enableEmptyAnnotation(false)
                    .maximumAnnotations(1)
                    .build();
            
            Project project = client.projects().create(projectRequest);
            logger.info("Created project: " + project.getTitle() + " (ID: " + project.getId() + ")");
            
            // 3. Validate label configuration
            logger.info("3. Validating label configuration...");
            LabelConfigValidationResult validation = client.projects().validateLabelConfig(project.getId(), labelConfig);
            if (validation.isValid()) {
                logger.info("   ✓ Label configuration is valid\n");
            } else {
                logger.info("   ✗ Label configuration has errors: " + validation.getErrors() + "\n");
            }
                    
            // 4. Import tasks
            logger.info("4. Creating tasks...");
            List<Map<String, Object>> taskData = Arrays.asList(
                    createMap("text", "I absolutely love this new product! It's amazing!"),
                    createMap("text", "This is the worst thing I've ever bought. Terrible quality."),
                    createMap("text", "It's okay, nothing special. Average quality for the price."),
                    createMap("text", "Fantastic customer service and quick delivery!"),
                    createMap("text", "Completely useless. I want my money back.")
            );
            
            // Create tasks one by one (alternatively, you could use importTasks for bulk import)
            for (int i = 0; i < taskData.size(); i++) {
                TaskCreateRequest taskRequest = TaskCreateRequest.builder()
                        .data(taskData.get(i))
                        .project(project.getId())
                        .build();
                
                Task task = client.tasks().create(taskRequest);
                logger.info("   Created task " + (i + 1) + ": " + task.getData().get("text"));
            }
            
            // 5. List tasks
            logger.info("5. Listing all tasks in the project...");
            TasksListOptions tasksListOptions = TasksListOptions.builder().project(project.getId()).build();
            Pagination<Task> tasks = client.tasks().list(tasksListOptions);
            logger.info("   Found " + tasks.getCount() + " tasks:");
            for (Task task : tasks.getResults()) {
                logger.info("   - Task " + task.getId() + ": " + task.getData().get("text"));
                logger.info("     Labeled: " + (task.getIsLabeled() != null ? task.getIsLabeled() : false));
            }
            
            // 5.1 Demonstrate advanced project listing with filters
            logger.info("5.1 Demonstrating advanced project listing...");
            Pagination<Project> filteredProjects = client.projects().list(
                ProjectsListOptions.builder()
                    .ordering("created_at:desc")
                    .pageSize(5)
                    .include("title,task_number,finished_task_number")  // Include title to ensure it's returned
                    .build()
            );
            logger.info("   Recent projects (max 5):");
            for (Project p : filteredProjects.getResults()) {
                String title = p.getTitle() != null ? p.getTitle() : "N/A";
                logger.info("   - " + title + " (Tasks: " + p.getTaskNumber() + ", Finished: " + p.getFinishedTaskNumber() + ")");
            }
            
            // 6. Create an annotation for the first task
            if (!tasks.getResults().isEmpty()) {
                logger.info("6. Creating an annotation for the first task...");
                Task firstTask = tasks.getResults().get(0);
                
                Map<String, Object> annotationMap = new HashMap<>();
                annotationMap.put("from_name", "sentiment");
                annotationMap.put("to_name", "text");
                annotationMap.put("type", "choices");
                
                Map<String, Object> valueMap = new HashMap<>();
                valueMap.put("choices", Arrays.asList("Positive"));
                annotationMap.put("value", valueMap);
                
                List<Map<String, Object>> annotationResult = Arrays.asList(annotationMap);
                
                AnnotationCreateRequest annotationRequest = AnnotationCreateRequest.builder()
                        .task(firstTask.getId())
                        .result(annotationResult)
                        .leadTime(5.0) // 5 seconds
                        .build();
                
                Annotation annotation = client.annotations().create(annotationRequest);
                logger.info("   Created annotation " + annotation.getId() + " for task " + firstTask.getId());
                logger.info("   Annotation result: " + annotation.getResult() + "\n");
            }
            
            // 7. Demonstrate export functionality
            logger.info("7. Creating and managing exports...");
            Export export = client.projects().exports(project.getId()).create(
                ExportCreateRequest.builder()
                    .title("SDK Example Export")
                    .exportType("json")
                    .downloadAllTasks(true)
                    .build()
            );
            logger.info("   Created export: " + export.getTitle() + " (ID: " + export.getId() + ")");
            logger.info("   Export status: " + export.getStatus());
            logger.info("   Export type: " + export.getExportType());
            
            // List all exports for the project
            List<Export> exports = client.projects().exports(project.getId()).list(null);
            logger.info("   Total exports for project: " + exports.size());
            for (Export e : exports) {
                logger.info("   - " + e.getTitle() + " (ID: " + e.getId() + ")");
                logger.info("     Status: " + e.getStatus());
                logger.info("     Type: " + e.getExportType());
            }
            
            // 8. List projects to verify everything was created
            logger.info("8. Listing all projects...");
            Pagination<Project> projects = client.projects().list();
            logger.info("   Total projects: " + projects.getCount());
            for (Project p : projects.getResults()) {
                logger.info("   - " + p.getTitle() + " (ID: " + p.getId() + ", Tasks: " + p.getTaskNumber() + ")");
            }
            
            // 9. Cleanup - delete all created resources
            logger.info("9. Cleaning up created resources...");
            
            try {
                // Delete exports
                List<Export> exportsToDelete = client.projects().exports(project.getId()).list(null);
                for (Export e : exportsToDelete) {
                    try {
                        client.projects().exports(project.getId()).delete(e.getId());
                        logger.info("   ✓ Deleted export: " + e.getTitle() + " (ID: " + e.getId() + ")");
                    } catch (Exception ex) {
                        logger.warn("   ✗ Failed to delete export " + e.getId() + ": " + ex.getMessage());
                    }
                }
                
                // Delete annotations
                if (!tasks.getResults().isEmpty()) {
                    for (Task task : tasks.getResults()) {
                        // Get annotations for this task
                        try {
                            Pagination<Annotation> annotations = client.annotations().list();
                            for (Annotation ann : annotations.getResults()) {
                                if (ann.getTask() != null && ann.getTask().equals(task.getId())) {
                                    try {
                                        client.annotations().delete(ann.getId());
                                        logger.info("   ✓ Deleted annotation " + ann.getId() + " for task " + task.getId());
                                    } catch (Exception ex) {
                                        logger.warn("   ✗ Failed to delete annotation " + ann.getId() + ": " + ex.getMessage());
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            logger.debug("   Could not list annotations: " + ex.getMessage());
                        }
                    }
                }
                
                // Delete tasks
                Pagination<Task> tasksToDelete = client.tasks().list(TasksListOptions.builder().project(project.getId()).build());
                for (Task task : tasksToDelete.getResults()) {
                    try {
                        client.tasks().delete(task.getId());
                        logger.info("   ✓ Deleted task " + task.getId());
                    } catch (Exception ex) {
                        logger.warn("   ✗ Failed to delete task " + task.getId() + ": " + ex.getMessage());
                    }
                }
                
                // Finally, delete the project
                client.projects().delete(project.getId());
                logger.info("   ✓ Deleted project: " + project.getTitle() + " (ID: " + project.getId() + ")");
                logger.info("\n=== Cleanup completed successfully! ===");
                
            } catch (Exception cleanupEx) {
                logger.warn("   Some cleanup operations failed: " + cleanupEx.getMessage());
                logger.info("\n=== Example completed (with cleanup warnings) ===");
            }
            
            logger.info("\n=== Example completed successfully! ===");
            
        } catch (ApiError e) {
            logger.error("API Error: " + e.getMessage());
            logger.error("Status Code: " + e.getStatusCode());
            logger.error("Response Body: " + e.getBody());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}