# CLAUDE.md

此文件为 Claude Code (claude.ai/code) 在处理此代码库时提供指导。

## 项目概述

这是一个综合性的 Spring Boot 学习项目，包含 35+ 个模块，展示了 Spring Boot 最佳实践和常见集成模式。每个模块专注于特定技术或与 Spring Boot 3.5.0 和 Java 21 的功能集成。

## 构建命令

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

## 项目架构

### 多模块结构
- **父级 POM**: 定义公共依赖和 Spring Boot 3.5.0 版本
- **独立模块**: 每个模块演示特定的 Spring Boot 功能
- **包命名约定**: `cn.javastack.springboot.{模块名}`
- **一致的应用类**: 简单的 `@SpringBootApplication` 配合功能特定注解

### 核心模块分类
- **核心模块**: web, webflux, logging, test, properties, features
- **数据模块**: jpa, mybatis, mybatis-plus, mongodb, elasticsearch, redis, datasource
- **消息模块**: activemq, rabbitmq, kafka
- **基础设施模块**: docker, actuator, admin-server/client, undertow, war
- **高级模块**: ai, graalvm, schedule, quartz, cache, aop, jasypt

### 配置模式
- **首选 YAML**: 大多数模块使用 `application.yml` 而非 properties 文件
- **配置文件管理**: 使用 `spring.profiles.active` 进行多环境配置
- **外部配置**: 导入模式和随机值生成
- **配置属性**: 大量使用 `@ConfigurationProperties` 和扫描

### 公共依赖（全局可用）
- **Lombok**: 减少样板代码
- **Apache Commons Lang3**: 通用工具
- **Spring Boot DevTools**: 开发时工具
- **Spring Boot Configuration Processor**: 配置元数据
- **Spring AI BOM**: AI 相关依赖（版本 1.0.0）

## 开发模式

### 控制器模式
- RESTful 控制器使用 `@RestController`
- Web 控制器使用 `@Controller` 配合视图模板
- 一致的命名: `{功能}Controller`
- 使用 `@ControllerAdvice` 进行全局异常处理

### 配置类
- 功能特定的 `@Configuration` 类
- 使用 Druid 连接池的数据源配置
- 需要认证的模块的安全配置
- 缓存和任务调度配置

### 测试方法
- 全项目使用 **JUnit 5 (Jupiter)**
- **Spring Boot 测试切片**: `@JsonTest`, `@MockMvc`, `@SpringBootTest`
- 使用 **AssertJ** 进行流式断言
- 使用 **MockMvc** 进行 Web 层测试
- 使用 **JacksonTester** 进行 JSON 序列化测试

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

## 常见开发任务

### 添加新模块
1. 按照命名约定创建新模块目录
2. 在父级 POM 的 `<modules>` 部分添加模块引用
3. 创建继承父级的模块特定 `pom.xml`
4. 遵循包结构: `cn.javastack.springboot.{模块名}`
5. 创建带有适当注解的 Application 类

### 配置管理
- 配置文件使用 YAML 格式
- 根据需要实现环境特定配置
- 使用 `@ConfigurationProperties` 进行类型安全配置
- 包含配置处理器依赖以生成元数据

### 运行独立模块
每个模块可独立运行:
```bash
cd spring-boot-{模块名}
mvn spring-boot:run
```

## 备注
- 项目中的中文注释表示"微信公众号：Java技术栈"
- 相关模块中的 SSL 配置使用 JKS 密钥库
- 许多模块通过 `CommandLineRunner` 包含演示数据或初始化
- properties 模块中的外部配置导入和随机值模式
- Spring AI 集成展示了 Spring Boot 应用程序中的现代 AI 功能