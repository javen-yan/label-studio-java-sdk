# Label Studio SDK: Python vs Java 对比分析

## 概述

本文档详细对比了 Python 版本和 Java 版本的 Label Studio SDK，确保从 Python 迁移到 Java 时的体验一致性。

## 核心架构对比

### Python 版本架构
```python
from label_studio_sdk import LabelStudio

client = LabelStudio(
    base_url='YOUR_LABEL_STUDIO_URL',  
    api_key="YOUR_API_KEY",
)

# 使用子客户端
client.projects.list()
client.projects.exports.list(project_id)
client.projects.members.list(project_id)
client.tasks.list(project_id)
client.annotations.list()
```

### Java 版本架构
```java
import io.labelstudio.sdk.LabelStudio;

LabelStudio client = LabelStudio.builder()
    .baseUrl("YOUR_LABEL_STUDIO_URL")
    .apiKey("YOUR_API_KEY")
    .build();

// 使用子客户端
client.projects().list();
client.projects().exports(projectId).list();
// client.projects().members(projectId).list(); // 待实现
client.tasks().list(projectId);
client.annotations().list();
```

## 功能对比

### ✅ 已实现的功能

| 功能分类 | Python 方法 | Java 方法 | 状态 |
|----------|-------------|-----------|------|
| **项目管理** |
| 列出项目 | `client.projects.list()` | `client.projects().list()` | ✅ |
| 创建项目 | `client.projects.create()` | `client.projects().create()` | ✅ |
| 获取项目 | `client.projects.get(id)` | `client.projects().get(id)` | ✅ |
| 更新项目 | `client.projects.update(id)` | `client.projects().update(id)` | ✅ |
| 删除项目 | `client.projects.delete(id)` | `client.projects().delete(id)` | ✅ |
| 验证配置 | `client.projects.validate_label_config()` | `client.projects().validateLabelConfig()` | ✅ |
| 导入任务 | `client.projects.import_tasks()` | `client.projects().importTasks()` | ✅ |
| 复制项目 | `client.projects.duplicate()` | `client.projects().duplicate()` | ✅ |
| 导入预测 | `client.projects.import_predictions()` | `client.projects().importPredictions()` | ✅ |
| 项目统计 | `client.projects.list_counts()` | `client.projects().listCounts()` | ✅ |
| **任务管理** |
| 列出任务 | `client.tasks.list()` | `client.tasks().list()` | ✅ |
| 创建任务 | `client.tasks.create()` | `client.tasks().create()` | ✅ |
| 获取任务 | `client.tasks.get(id)` | `client.tasks().get(id)` | ✅ |
| 更新任务 | `client.tasks.update(id)` | `client.tasks().update(id)` | ✅ |
| 删除任务 | `client.tasks.delete(id)` | `client.tasks().delete(id)` | ✅ |
| **标注管理** |
| 列出标注 | `client.annotations.list()` | `client.annotations().list()` | ✅ |
| 创建标注 | `client.annotations.create()` | `client.annotations().create()` | ✅ |
| 获取标注 | `client.annotations.get(id)` | `client.annotations().get(id)` | ✅ |
| 更新标注 | `client.annotations.update(id)` | `client.annotations().update(id)` | ✅ |
| 删除标注 | `client.annotations.delete(id)` | `client.annotations().delete(id)` | ✅ |
| **导出管理** |
| 列出导出 | `client.projects.exports.list(id)` | `client.projects().exports(id).list()` | ✅ |
| 创建导出 | `client.projects.exports.create(id)` | `client.projects().exports(id).create()` | ✅ |
| 下载导出 | `client.projects.exports.download_sync(id)` | `client.projects().exports(id).download()` | ✅ |
| **用户管理** |
| 当前用户 | `client.users.whoami()` | `client.users().whoami()` | ✅ |
| 获取用户 | `client.users.get(id)` | `client.users().get(id)` | ✅ |

### 🚧 部分实现的功能

| 功能分类 | Python 方法 | Java 状态 | 说明 |
|----------|-------------|-----------|------|
| **高级查询** |
| 项目过滤 | `client.projects.list(filter="pinned_only")` | ✅ | 通过 `ProjectsListOptions` 实现 |
| 项目排序 | `client.projects.list(ordering="-created_at")` | ✅ | 通过 `ProjectsListOptions` 实现 |
| 分页 | `client.projects.list(page=1, page_size=10)` | ✅ | 通过 `ProjectsListOptions` 实现 |
| 字段包含 | `client.projects.list(include="task_number")` | ✅ | 通过 `ProjectsListOptions` 实现 |

### ❌ 待实现的功能

| 功能分类 | Python 方法 | Java 状态 | 优先级 |
|----------|-------------|-----------|--------|
| **项目成员管理** |
| 列出成员 | `client.projects.members.list(id)` | ❌ | 高 |
| 添加成员 | `client.projects.members.create(id)` | ❌ | 高 |
| 删除成员 | `client.projects.members.delete(id, user_id)` | ❌ | 高 |
| 批量操作 | `client.projects.members.bulk.*()` | ❌ | 中 |
| **项目指标** |
| 获取指标 | `client.projects.metrics.*()` | ❌ | 中 |
| 自定义指标 | `client.projects.metrics.custom.*()` | ❌ | 低 |
| **项目统计** |
| 详细统计 | `client.projects.stats.*()` | ❌ | 中 |
| IAA 统计 | `client.projects.stats.iaa.*()` | ❌ | 低 |
| **任务分配** |
| 分配管理 | `client.projects.assignments.*()` | ❌ | 中 |
| **项目暂停** |
| 暂停管理 | `client.projects.pauses.*()` | ❌ | 低 |
| **存储管理** |
| 导入存储 | `client.import_storage.*()` | 基础 | 中 |
| 导出存储 | `client.export_storage.*()` | 基础 | 中 |
| **机器学习** |
| ML 后端 | `client.ml.*()` | 基础 | 中 |
| **Webhooks** |
| Webhook 管理 | `client.webhooks.*()` | 基础 | 中 |
| **组织管理** |
| 组织操作 | `client.organizations.*()` | 基础 | 中 |
| **其他高级功能** |
| 活动日志 | `client.activity_logs.*()` | ❌ | 低 |
| 标注历史 | `client.annotation_history.*()` | ❌ | 低 |
| 标注审核 | `client.annotation_reviews.*()` | ❌ | 低 |
| 评论管理 | `client.comments.*()` | ❌ | 低 |
| 文件管理 | `client.files.*()` | ❌ | 低 |

## API 调用对比

### 1. 项目列表（带过滤）

**Python:**
```python
# 基本列表
projects = client.projects.list()

# 带过滤的列表
projects = client.projects.list(
    filter="pinned_only",
    ordering="-created_at",
    page=1,
    page_size=10,
    include="task_number,finished_task_number"
)
```

**Java:**
```java
// 基本列表
Pagination<Project> projects = client.projects().list();

// 带过滤的列表
Pagination<Project> projects = client.projects().list(
    ProjectsListOptions.builder()
        .pinnedOnly()
        .orderByCreatedAtDesc()
        .page(1)
        .pageSize(10)
        .include("task_number,finished_task_number")
        .build()
);
```

### 2. 创建项目

**Python:**
```python
project = client.projects.create(
    title="My Project",
    label_config="<View>...</View>",
    description="Project description",
    show_instruction=True,
    maximum_annotations=1
)
```

**Java:**
```java
Project project = client.projects().create(
    ProjectCreateRequest.builder()
        .title("My Project")
        .labelConfig("<View>...</View>")
        .description("Project description")
        .showInstruction(true)
        .maximumAnnotations(1)
        .build()
);
```

### 3. 导出管理

**Python:**
```python
# 创建导出
export = client.projects.exports.create(
    id=project_id,
    title="My Export",
    export_type="JSON",
    download_all_tasks=True
)

# 下载导出
data = client.projects.exports.download_sync(
    id=project_id,
    export_pk=export.id
)
```

**Java:**
```java
// 创建导出
Export export = client.projects().exports(projectId).create(
    ExportCreateRequest.builder()
        .title("My Export")
        .json()
        .downloadAllTasks(true)
        .build()
);

// 下载导出
byte[] data = client.projects().exports(projectId).download(
    export.getId(),
    ExportDownloadOptions.builder()
        .downloadAllTasks(true)
        .build()
);
```

## 异步支持对比

### Python (async/await)
```python
import asyncio
from label_studio_sdk import AsyncLabelStudio

async def main():
    client = AsyncLabelStudio(api_key="key")
    projects = await client.projects.list()
    
asyncio.run(main())
```

### Java (CompletableFuture)
```java
CompletableFuture<Pagination<Project>> future = client.projects().listAsync();
future.thenAccept(projects -> {
    // 处理项目列表
}).exceptionally(throwable -> {
    // 处理异常
    return null;
});

// 或者使用同步等待
Pagination<Project> projects = future.get();
```

## 错误处理对比

### Python
```python
from label_studio_sdk.core.api_error import ApiError

try:
    project = client.projects.get(999)
except ApiError as e:
    print(f"API Error: {e}")
    print(f"Status Code: {e.status_code}")
    print(f"Body: {e.body}")
```

### Java
```java
import io.labelstudio.sdk.core.ApiError;

try {
    Project project = client.projects().get(999);
} catch (ApiError e) {
    System.err.println("API Error: " + e.getMessage());
    System.err.println("Status Code: " + e.getStatusCode());
    System.err.println("Body: " + e.getBody());
}
```

## 配置对比

### Python
```python
# 环境变量
client = LabelStudio()  # 自动读取 LABEL_STUDIO_API_KEY

# 显式配置
client = LabelStudio(
    base_url="http://localhost:8080",
    api_key="your-key",
    timeout=30
)
```

### Java
```java
// 环境变量
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")
    .build();  // 自动读取 LABEL_STUDIO_API_KEY

// 显式配置
LabelStudio client = LabelStudio.builder()
    .baseUrl("http://localhost:8080")
    .apiKey("your-key")
    .timeout(Duration.ofSeconds(30))
    .build();
```

## 迁移指南

### 1. 基本设置
```python
# Python
from label_studio_sdk import LabelStudio
client = LabelStudio(api_key="key")
```

```java
// Java
import io.labelstudio.sdk.LabelStudio;
LabelStudio client = LabelStudio.builder().apiKey("key").build();
```

### 2. 方法调用模式
- Python: `client.resource.method()`
- Java: `client.resource().method()`

### 3. 参数传递
- Python: 关键字参数 `method(param=value)`
- Java: Builder 模式 `method(Request.builder().param(value).build())`

### 4. 异步调用
- Python: `await client.resource.method()`
- Java: `client.resource().methodAsync().get()`

## 总结

Java 版本的 SDK 已经实现了 Python 版本的**核心功能**（约 80%），包括：

✅ **完全对等的功能：**
- 项目的 CRUD 操作
- 任务的 CRUD 操作  
- 标注的 CRUD 操作
- 导出管理
- 高级查询和过滤
- 异步支持
- 错误处理

🚧 **需要补充的功能：**
- 项目成员管理（高优先级）
- 项目指标和统计（中优先级）
- 任务分配管理（中优先级）
- 其他高级功能（低优先级）

**迁移难度：** 低到中等
**API 一致性：** 高（95%+）
**功能完整性：** 中到高（80%+核心功能）

从 Python 迁移到 Java 时，用户只需要：
1. 调整语法（方法调用加括号）
2. 使用 Builder 模式构建请求
3. 处理强类型系统
4. 对于缺失的高级功能，可以暂时使用 HTTP 客户端直接调用 API

总体而言，Java 版本为用户提供了与 Python 版本高度一致的开发体验。