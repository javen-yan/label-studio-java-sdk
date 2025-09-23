# Label Studio Java SDK

A Java client library for the [Label Studio](https://labelstud.io/) API, providing convenient access to Label Studio's features from Java applications.

## Features

- **Complete API Coverage**: Support for projects, tasks, annotations, users, and more
- **Type Safety**: Strongly typed models and requests/responses
- **Async Support**: Both synchronous and asynchronous API calls
- **Builder Pattern**: Fluent API for creating requests
- **Pagination**: Built-in support for paginated responses
- **Error Handling**: Comprehensive error handling with detailed error information

## Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.labelstudio</groupId>
    <artifactId>label-studio-sdk</artifactId>
    <version>2.0.0</version>
</dependency>
```

Or if you're using Gradle, add to your `build.gradle`:

```gradle
implementation 'io.labelstudio:label-studio-sdk:2.0.0'
```

## Quick Start

### Basic Setup

```java
import io.labelstudio.sdk.LabelStudio;
import io.labelstudio.sdk.client.ProjectCreateRequest;
import io.labelstudio.sdk.models.Project;

// Create a client
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")  // Your Label Studio URL
    .apiKey("your-api-key")            // Your API key
    .build();
```

### Create a Project

```java
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
    .title("Sentiment Classification")
    .description("A project for classifying text sentiment")
    .labelConfig(labelConfig)
    .showInstruction(true)
    .enableEmptyAnnotation(false)
    .maximumAnnotations(1)
    .build();

Project project = client.projects().create(request);
System.out.println("Created project: " + project.getTitle());
```

### Import Tasks

```java
import java.util.*;

// Prepare task data
List<Map<String, Object>> tasks = Arrays.asList(
    Map.of("text", "I love this product!"),
    Map.of("text", "This is terrible."),
    Map.of("text", "It's okay, nothing special.")
);

// Import tasks into the project
TaskImportResult result = client.projects().importTasks(project.getId(), tasks);
System.out.println("Imported " + result.getTaskCount() + " tasks");
```

### List and Work with Tasks

```java
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.Task;

// List tasks in a project
Pagination<Task> tasks = client.tasks().list(project.getId());

for (Task task : tasks.getResults()) {
    System.out.println("Task ID: " + task.getId());
    System.out.println("Data: " + task.getData());
    System.out.println("Is labeled: " + task.getIsLabeled());
}
```

### Create Annotations

```java
import io.labelstudio.sdk.client.AnnotationCreateRequest;
import io.labelstudio.sdk.models.Annotation;

// Create annotation result
List<Map<String, Object>> result = Arrays.asList(
    Map.of(
        "from_name", "sentiment",
        "to_name", "text",
        "type", "choices",
        "value", Map.of("choices", Arrays.asList("Positive"))
    )
);

AnnotationCreateRequest annotationRequest = AnnotationCreateRequest.builder()
    .task(task.getId())
    .result(result)
    .build();

Annotation annotation = client.annotations().create(annotationRequest);
System.out.println("Created annotation: " + annotation.getId());
```

### Async Operations

```java
import java.util.concurrent.CompletableFuture;

// All client methods have async variants
CompletableFuture<Project> futureProject = client.projects().createAsync(request);

futureProject.thenAccept(project -> {
    System.out.println("Project created asynchronously: " + project.getTitle());
}).exceptionally(throwable -> {
    System.err.println("Failed to create project: " + throwable.getMessage());
    return null;
});
```

## Configuration

### Environment Configuration

You can use predefined environments:

```java
LabelStudio client = LabelStudio.builder()
    .environment(LabelStudioEnvironment.PRODUCTION)  // or DEFAULT, STAGING
    .apiKey("your-api-key")
    .build();
```

### Custom Configuration

```java
import java.time.Duration;

LabelStudio client = LabelStudio.builder()
    .baseUrl("https://custom-labelstudio.com")
    .apiKey("your-api-key")
    .timeout(Duration.ofSeconds(30))  // Custom timeout
    .build();
```

### API Key from Environment

The SDK automatically reads the API key from the `LABEL_STUDIO_API_KEY` environment variable:

```java
// API key will be read from LABEL_STUDIO_API_KEY environment variable
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")
    .build();
```

## Error Handling

```java
import io.labelstudio.sdk.core.ApiError;

try {
    Project project = client.projects().get(999); // Non-existent project
} catch (ApiError e) {
    System.err.println("API Error: " + e.getMessage());
    System.err.println("Status Code: " + e.getStatusCode());
    System.err.println("Response Body: " + e.getBody());
}
```

## Pagination

```java
import io.labelstudio.sdk.core.Pagination;

Pagination<Project> projects = client.projects().list();

System.out.println("Total projects: " + projects.getCount());
System.out.println("Current page size: " + projects.getPageSize());
System.out.println("Has next page: " + projects.hasNext());

// Process all projects
for (Project project : projects.getResults()) {
    System.out.println("Project: " + project.getTitle());
}
```

## Advanced Usage

### Request Options

```java
import io.labelstudio.sdk.core.RequestOptions;
import java.time.Duration;

RequestOptions options = RequestOptions.builder()
    .timeout(Duration.ofSeconds(10))
    .addHeader("Custom-Header", "value")
    .build();

Project project = client.projects().get(1, options);
```

### Label Configuration Validation

```java
String labelConfig = """
    <View>
      <Text name="text" value="$text"/>
      <Choices name="sentiment" toName="text">
        <Choice value="Positive"/>
        <Choice value="Negative"/>
      </Choices>
    </View>
    """;

LabelConfigValidationResult validation = client.projects()
    .validateLabelConfig(project.getId(), labelConfig);

if (validation.isValid()) {
    System.out.println("Label config is valid!");
} else {
    System.out.println("Validation errors: " + validation.getErrors());
}
```

## Building from Source

```bash
git clone https://github.com/javen-yan/label-studio-sdk-java.git
cd label-studio-sdk-java
mvn clean install
```

## Requirements

- Java 11 or higher
- Maven 3.6+ or Gradle 6+

## Dependencies

- **OkHttp**: HTTP client
- **Jackson**: JSON processing
- **SLF4J**: Logging facade
- **JUnit 5**: Testing (test scope)

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes
4. Add tests for your changes
5. Commit your changes (`git commit -m 'Add amazing feature'`)
6. Push to the branch (`git push origin feature/amazing-feature`)
7. Open a Pull Request

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Support

- **Documentation**: [Label Studio API Documentation](https://api.labelstud.io/)
- **Issues**: [GitHub Issues](https://github.com/javen-yan/label-studio-sdk-java/issues)
- **Community**: [Label Studio Slack](https://slack.labelstud.io/)

## Changelog

### Version 2.0.0
- Initial release of Java SDK
- Support for core Label Studio API operations
- Async API support
- Comprehensive type safety
- Builder pattern for requests
- Pagination support