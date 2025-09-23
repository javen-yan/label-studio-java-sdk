# 从 Python SDK 迁移到 Java SDK 指南

本指南帮助开发者从 Python 版本的 Label Studio SDK 无缝迁移到 Java 版本。

## 快速对照表

### 1. 客户端初始化

| Python | Java |
|--------|------|
| ```python<br>from label_studio_sdk import LabelStudio<br><br>client = LabelStudio(<br>    base_url='http://localhost:8080',<br>    api_key="your-api-key"<br>)``` | ```java<br>import io.labelstudio.sdk.LabelStudio;<br><br>LabelStudio client = LabelStudio.builder()<br>    .baseUrl("http://localhost:8080")<br>    .apiKey("your-api-key")<br>    .build();``` |

### 2. 项目操作

| 操作 | Python | Java |
|------|--------|------|
| **列出项目** | `client.projects.list()` | `client.projects().list()` |
| **创建项目** | ```python<br>client.projects.create(<br>    title="My Project",<br>    label_config="<View>...</View>"<br>)``` | ```java<br>client.projects().create(<br>    ProjectCreateRequest.builder()<br>        .title("My Project")<br>        .labelConfig("<View>...</View>")<br>        .build()<br>)``` |
| **获取项目** | `client.projects.get(project_id)` | `client.projects().get(projectId)` |
| **更新项目** | ```python<br>client.projects.update(<br>    id=project_id,<br>    title="Updated Title"<br>)``` | ```java<br>client.projects().update(projectId,<br>    ProjectUpdateRequest.builder()<br>        .title("Updated Title")<br>        .build()<br>)``` |
| **删除项目** | `client.projects.delete(project_id)` | `client.projects().delete(projectId)` |

### 3. 高级项目查询

| 功能 | Python | Java |
|------|--------|------|
| **过滤项目** | ```python<br>client.projects.list(<br>    filter="pinned_only",<br>    ordering="-created_at",<br>    page_size=10<br>)``` | ```java<br>client.projects().list(<br>    ProjectsListOptions.builder()<br>        .pinnedOnly()<br>        .orderByCreatedAtDesc()<br>        .pageSize(10)<br>        .build()<br>)``` |
| **包含字段** | ```python<br>client.projects.list(<br>    include="task_number,finished_task_number"<br>)``` | ```java<br>client.projects().list(<br>    ProjectsListOptions.builder()<br>        .include("task_number,finished_task_number")<br>        .build()<br>)``` |

### 4. 任务操作

| 操作 | Python | Java |
|------|--------|------|
| **列出任务** | `client.tasks.list(project_id)` | `client.tasks().list(projectId)` |
| **创建任务** | ```python<br>client.tasks.create(<br>    project=project_id,<br>    data={"text": "Hello World"}<br>)``` | ```java<br>client.tasks().create(projectId,<br>    TaskCreateRequest.builder()<br>        .data(Map.of("text", "Hello World"))<br>        .project(projectId)<br>        .build()<br>)``` |

### 5. 标注操作

| 操作 | Python | Java |
|------|--------|------|
| **创建标注** | ```python<br>client.annotations.create(<br>    task=task_id,<br>    result=[{<br>        "from_name": "sentiment",<br>        "to_name": "text",<br>        "type": "choices",<br>        "value": {"choices": ["Positive"]}<br>    }]<br>)``` | ```java<br>client.annotations().create(<br>    AnnotationCreateRequest.builder()<br>        .task(taskId)<br>        .result(Arrays.asList(Map.of(<br>            "from_name", "sentiment",<br>            "to_name", "text",<br>            "type", "choices",<br>            "value", Map.of("choices", Arrays.asList("Positive"))<br>        )))<br>        .build()<br>)``` |

### 6. 导出操作

| 操作 | Python | Java |
|------|--------|------|
| **创建导出** | ```python<br>client.projects.exports.create(<br>    id=project_id,<br>    title="My Export",<br>    export_type="JSON"<br>)``` | ```java<br>client.projects().exports(projectId).create(<br>    ExportCreateRequest.builder()<br>        .title("My Export")<br>        .json()<br>        .build()<br>)``` |
| **下载导出** | ```python<br>data = client.projects.exports.download_sync(<br>    id=project_id,<br>    export_pk=export_id<br>)``` | ```java<br>byte[] data = client.projects().exports(projectId)<br>    .download(exportId, null);``` |

### 7. 异步操作

| Python (async/await) | Java (CompletableFuture) |
|---------------------|--------------------------|
| ```python<br>from label_studio_sdk import AsyncLabelStudio<br><br>client = AsyncLabelStudio(api_key="key")<br>projects = await client.projects.list()``` | ```java<br>CompletableFuture<Pagination<Project>> future = <br>    client.projects().listAsync();<br><br>future.thenAccept(projects -> {<br>    // 处理项目列表<br>});``` |

## 详细迁移步骤

### 步骤 1: 更新依赖

**移除 Python 依赖:**
```bash
pip uninstall label-studio-sdk
```

**添加 Java 依赖:**
```xml
<!-- Maven -->
<dependency>
    <groupId>io.labelstudio</groupId>
    <artifactId>label-studio-sdk</artifactId>
    <version>2.0.0</version>
</dependency>
```

```gradle
// Gradle
implementation 'io.labelstudio:label-studio-sdk:2.0.0'
```

### 步骤 2: 更新导入语句

**Python:**
```python
from label_studio_sdk import LabelStudio
from label_studio_sdk.core.api_error import ApiError
```

**Java:**
```java
import io.labelstudio.sdk.LabelStudio;
import io.labelstudio.sdk.core.ApiError;
import io.labelstudio.sdk.client.*;
import io.labelstudio.sdk.models.*;
```

### 步骤 3: 转换客户端初始化

**Python:**
```python
# 使用环境变量
client = LabelStudio()

# 显式配置
client = LabelStudio(
    base_url="http://localhost:8080",
    api_key="your-api-key",
    timeout=30
)
```

**Java:**
```java
// 使用环境变量
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")
    .build();

// 显式配置
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")
    .apiKey("your-api-key")
    .timeout(Duration.ofSeconds(30))
    .build();
```

### 步骤 4: 转换方法调用

主要变化：
1. **方法调用**: `client.resource.method()` → `client.resource().method()`
2. **参数传递**: 关键字参数 → Builder 模式
3. **异常处理**: 保持相同的 `ApiError`

### 步骤 5: 更新错误处理

**Python:**
```python
try:
    project = client.projects.get(999)
except ApiError as e:
    print(f"Error: {e}")
```

**Java:**
```java
try {
    Project project = client.projects().get(999);
} catch (ApiError e) {
    System.err.println("Error: " + e.getMessage());
}
```

## 常见迁移模式

### 1. 列表操作

**Python:**
```python
# 简单列表
projects = client.projects.list()
for project in projects:
    print(project.title)

# 分页处理
for page in client.projects.list().iter_pages():
    for project in page:
        print(project.title)
```

**Java:**
```java
// 简单列表
Pagination<Project> projects = client.projects().list();
for (Project project : projects.getResults()) {
    System.out.println(project.getTitle());
}

// 分页处理
Pagination<Project> page = client.projects().list();
while (page != null) {
    for (Project project : page.getResults()) {
        System.out.println(project.getTitle());
    }
    // 获取下一页的逻辑需要根据具体实现
    if (!page.hasNext()) break;
    // page = getNextPage(page);
}
```

### 2. 创建操作

**Python:**
```python
project = client.projects.create(
    title="My Project",
    description="Project description",
    label_config="<View>...</View>",
    show_instruction=True,
    maximum_annotations=1
)
```

**Java:**
```java
Project project = client.projects().create(
    ProjectCreateRequest.builder()
        .title("My Project")
        .description("Project description")
        .labelConfig("<View>...</View>")
        .showInstruction(true)
        .maximumAnnotations(1)
        .build()
);
```

### 3. 异步操作

**Python:**
```python
import asyncio

async def main():
    client = AsyncLabelStudio(api_key="key")
    
    # 并行执行多个操作
    projects_task = client.projects.list()
    tasks_task = client.tasks.list(project_id)
    
    projects, tasks = await asyncio.gather(projects_task, tasks_task)
    
    return projects, tasks

projects, tasks = asyncio.run(main())
```

**Java:**
```java
// 并行执行多个操作
CompletableFuture<Pagination<Project>> projectsFuture = 
    client.projects().listAsync();
CompletableFuture<Pagination<Task>> tasksFuture = 
    client.tasks().listAsync(projectId);

CompletableFuture.allOf(projectsFuture, tasksFuture)
    .thenRun(() -> {
        try {
            Pagination<Project> projects = projectsFuture.get();
            Pagination<Task> tasks = tasksFuture.get();
            // 处理结果
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
```

## 注意事项

### 1. 类型安全
Java 版本提供了强类型支持，IDE 会提供更好的自动完成和编译时错误检查。

### 2. 空值处理
Java 版本使用 `Integer` 等包装类型来表示可能为空的字段，需要进行空值检查：

```java
if (task.getIsLabeled() != null && task.getIsLabeled()) {
    // 任务已标注
}
```

### 3. 集合处理
Java 版本使用泛型集合：

```java
List<Map<String, Object>> result = annotation.getResult();
```

### 4. 日期时间
Java 版本使用 `OffsetDateTime`：

```java
OffsetDateTime createdAt = project.getCreatedAt();
```

## 完整示例

### Python 版本
```python
from label_studio_sdk import LabelStudio

client = LabelStudio(api_key="your-api-key")

# 创建项目
project = client.projects.create(
    title="Sentiment Analysis",
    label_config="""
    <View>
      <Text name="text" value="$text"/>
      <Choices name="sentiment" toName="text" choice="single">
        <Choice value="Positive"/>
        <Choice value="Negative"/>
      </Choices>
    </View>
    """
)

# 导入任务
client.projects.import_tasks(
    id=project.id,
    request=[
        {"text": "I love this!"},
        {"text": "This is terrible."}
    ]
)

# 列出任务
tasks = client.tasks.list(project.id)
print(f"Found {len(tasks)} tasks")
```

### Java 版本
```java
import io.labelstudio.sdk.LabelStudio;
import io.labelstudio.sdk.client.*;
import io.labelstudio.sdk.models.*;
import java.util.*;

LabelStudio client = LabelStudio.builder()
    .apiKey("your-api-key")
    .build();

// 创建项目
Project project = client.projects().create(
    ProjectCreateRequest.builder()
        .title("Sentiment Analysis")
        .labelConfig("""
            <View>
              <Text name="text" value="$text"/>
              <Choices name="sentiment" toName="text" choice="single">
                <Choice value="Positive"/>
                <Choice value="Negative"/>
              </Choices>
            </View>
            """)
        .build()
);

// 导入任务
List<Map<String, Object>> tasks = Arrays.asList(
    Map.of("text", "I love this!"),
    Map.of("text", "This is terrible.")
);
TaskImportResult result = client.projects().importTasks(project.getId(), tasks);

// 列出任务
Pagination<Task> tasksPagination = client.tasks().list(project.getId());
System.out.println("Found " + tasksPagination.getCount() + " tasks");
```

## 总结

Java 版本的 SDK 提供了与 Python 版本高度一致的 API，主要差异在于：

1. **语法差异**: Java 的强类型和方法调用语法
2. **参数传递**: 使用 Builder 模式代替关键字参数
3. **异步模型**: 使用 CompletableFuture 代替 async/await
4. **类型安全**: 提供编译时类型检查

通过遵循本指南，您可以快速将现有的 Python 代码迁移到 Java，同时享受强类型系统带来的好处。