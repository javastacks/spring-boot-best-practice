# Spring Boot 最佳实践项目概述

## 项目简介

这是一个综合性的 Spring Boot 学习项目，包含 35+ 个模块，展示了 Spring Boot 最佳实践和常见集成模式。每个模块专注于特定技术或与 Spring Boot 3.5.0 和 Java 21 的功能集成。

## 技术栈

- **核心框架**: Spring Boot 3.5.0
- **Java 版本**: Java 21
- **构建工具**: Maven
- **公共依赖**:
  - Lombok: 减少样板代码
  - Apache Commons Lang3: 通用工具
  - Spring Boot DevTools: 开发时工具
  - Spring Boot Configuration Processor: 配置元数据
  - Spring AI BOM: AI 相关依赖（版本 1.0.0）

## 项目架构

### 多模块结构

项目采用多模块 Maven 结构，包含以下核心模块分类：

1. **核心模块**:
   - web: 传统的 Spring MVC Web 应用
   - webflux: 响应式 Web 应用
   - logging: 日志配置和管理
   - test: 测试框架和最佳实践
   - properties: 配置属性管理
   - features: Spring Boot 特性演示

2. **数据模块**:
   - jpa: Spring Data JPA 集成
   - mybatis: MyBatis ORM 集成
   - mybatis-plus: MyBatis-Plus 增强功能
   - mongodb: MongoDB NoSQL 数据库集成
   - elasticsearch: Elasticsearch 搜索引擎集成
   - redis: Redis 缓存和会话管理
   - datasource: 多数据源配置

3. **消息模块**:
   - activemq: ActiveMQ 消息队列集成
   - rabbitmq: RabbitMQ 消息队列集成
   - kafka: Apache Kafka 流处理平台集成

4. **基础设施模块**:
   - docker: Docker 容器化支持
   - actuator: 生产监控和管理端点
   - admin-server/client: Spring Boot Admin 服务端和客户端
   - undertow: Undertow 嵌入式服务器替代方案
   - war: WAR 包部署支持

5. **高级模块**:
   - ai: Spring AI 集成（DeepSeek 等模型）
   - graalvm: GraalVM 原生镜像支持
   - schedule: 任务调度
   - quartz: Quartz 调度框架集成
   - cache: 缓存管理
   - aop: 面向切面编程
   - jasypt: 配置加密

### 配置模式

- **首选 YAML**: 大多数模块使用 `application.yml` 而非 properties 文件
- **配置文件管理**: 使用 `spring.profiles.active` 进行多环境配置
- **外部配置**: 导入模式和随机值生成
- **配置属性**: 大量使用 `@ConfigurationProperties` 和扫描

### 开发模式

#### 控制器模式
- RESTful 控制器使用 `@RestController`
- Web 控制器使用 `@Controller` 配合视图模板
- 一致的命名: `{功能}Controller`
- 使用 `@ControllerAdvice` 进行全局异常处理

#### 配置类
- 功能特定的 `@Configuration` 类
- 使用 Druid 连接池的数据源配置
- 需要认证的模块的安全配置
- 缓存和任务调度配置

#### 测试方法
- 全项目使用 **JUnit 5 (Jupiter)**
- **Spring Boot 测试切片**: `@JsonTest`, `@MockMvc`, `@SpringBootTest`
- 使用 **AssertJ** 进行流式断言
- 使用 **MockMvc** 进行 Web 层测试
- 使用 **JacksonTester** 进行 JSON 序列化测试

## 构建和运行

### 构建命令

```bash
# 构建整个项目
mvn clean compile

# 构建特定模块
mvn clean compile -pl spring-boot-{模块名}

# 打包项目
mvn clean package

# 运行特定模块
cd spring-boot-{模块名}
mvn spring-boot:run

# 运行测试
mvn test

# 运行特定模块的测试
mvn test -pl spring-boot-{模块名}
```

### 运行独立模块

每个模块可独立运行:
```bash
cd spring-boot-{模块名}
mvn spring-boot:run
```

## 特定技术使用

### 数据库模块
- **JPA**: 基础实体管理和仓库
- **MyBatis/MyBatis-Plus**: SQL 映射和增强 ORM 功能
- **MongoDB**: NoSQL 文档数据库集成
- **Redis**: 缓存和会话管理
- **Elasticsearch**: 搜索和分析引擎

### 消息模块
- **ActiveMQ**: 传统消息代理
- **RabbitMQ**: 高级消息队列
- **Kafka**: 分布式流处理平台

### 基础设施模块
- **Docker**: 容器化及 Dockerfile 示例
- **Actuator**: 生产监控和管理
- **Admin**: Spring Boot Admin 服务端/客户端设置
- **Undertow**: 替代嵌入式服务器配置

## 项目特点

1. **模块化设计**: 每个模块专注于特定技术，便于学习和集成
2. **最佳实践**: 遵循 Spring Boot 和企业级应用开发的最佳实践
3. **现代技术**: 集成最新的 Spring Boot 3.5.0 特性和 Java 21 功能
4. **完整示例**: 每个模块都包含完整的可运行示例和测试用例
5. **配置管理**: 采用 YAML 配置和类型安全的配置属性
6. **测试覆盖**: 包含各种测试策略，从单元测试到集成测试
7. **安全性**: 包含安全配置示例，如 Spring Security 集成
8. **监控管理**: 通过 Actuator 和 Admin 提供生产级监控能力
9. **容器化**: 提供 Docker 支持和容器化部署示例
10. **AI 集成**: 展示了现代 Spring Boot 应用程序中的 AI 功能集成

## 适用人群

- Spring Boot 初学者和进阶开发者
- 希望了解 Spring Boot 最佳实践的开发人员
- 需要集成特定技术到 Spring Boot 项目中的团队
- 对微服务架构和企业级应用开发感兴趣的技术人员