# spring-boot-best-practice

中文 | [English](./README.en.md)

> :rocket: 本仓库提供了 Spring Boot 主流知识点实战示例，大家可以随意下载学习。
>
> :star: 本项目会长期更新，为避免迷路，请点击右上角 **Star** 关注本项目。

## :fire: 为什么要学 Spring Boot？

> 本仓库已适配 **Spring Boot 4.x**，当前基线版本为 **Spring Boot 4.0.3**，配套 **Spring Framework 7.x** 与 **Java 21**。
> 
> 所有示例均围绕真实开发场景构建，既可作为 Spring Boot 学习仓库，也可作为 Spring Boot 4.x 升级与迁移参考。

Spring 作为 Java 开发界的万能框架，曾经和 Struts2、Hibernate 框架组成 SSH，成为 Java Web 开发的三驾马车。大概在 2013 年左右，又和 Spring MVC、MyBatis 框架组成 SSM，成为新一代的 Web 开发框架全家桶，一直流行延续至今。

**而为了简化 Spring 框架的上手难度**，Spring Boot 框架于 2014 年诞生，可以帮助开发者更加轻松、快捷地使用 Spring 的组件，它是 Spring、Spring MVC 等框架更上一层的框架，它需要依赖于 Spring、Spring MVC 等原生框架，而不能独立存在。

学会 Spring Boot，可以简化使用 Spring 基础组件的难度，还是学习 Spring Cloud 微服务框架的基础，**因为 Spring Cloud 的基础就是 Spring Boot。**

Spring Boot 代表了企业的真实需求，它表现在 Java 工程师、架构师的**求职面试技能清单上，Spring Boot 几乎是必备技能。** 所以，要成为合格的 Java 程序员，要学习 Spring 全家桶，Spring Boot 则是必经之路。

## :pushpin: 模块说明

本仓库采用 Maven 多模块组织方式，覆盖 **Spring Boot 常见核心能力、数据访问、消息中间件、运维治理、容器部署与工程实践**等主题，方便按专题学习和按模块验证。

| 模块名称 | 模块说明 |
| --- | --- |
| `spring-boot-quick-start` | Spring Boot 快速入门与基础启动示例。 |
| `spring-boot-application` | 应用启动、异步调用与应用级基础能力示例。 |
| `spring-boot-web` | Spring MVC Web 基础能力示例，包括消息转换、拦截器、Servlet 注册等。 |
| `spring-boot-webflux` | Spring WebFlux 与 `WebClient` 响应式开发示例。 |
| `spring-boot-logging` | Spring Boot 日志体系与日志输出配置示例。 |
| `spring-boot-test` | Spring Boot 测试体系示例，包括 `MockMvc`、`MockBean`、JSON 测试等。 |
| `spring-boot-aop` | Spring AOP 切面编程示例。 |
| `spring-boot-mail` | Spring Boot 邮件发送示例。 |
| `spring-boot-properties` | 配置文件、配置绑定与自定义属性类示例。 |
| `javastack-spring-boot-starter` | 自定义 Spring Boot Starter 开发示例。 |
| `javastack-spring-boot-starter-sample` | 自定义 Starter 的接入与使用示例。 |
| `spring-boot-jetty` | 使用 Jetty 作为嵌入式 Web 容器的示例。 |
| `spring-boot-redis` | Redis 集成、缓存访问与常用操作示例。 |
| `spring-boot-mongodb` | MongoDB 集成示例。 |
| `spring-boot-elasticsearch` | Elasticsearch 集成示例。 |
| `spring-boot-session` | Spring Session 分布式会话管理示例。 |
| `spring-boot-docker` | Docker 镜像构建、分层打包与容器化部署示例。 |
| `spring-boot-features` | Spring Boot 常见特性与启动行为示例。 |
| `spring-boot-datasource` | 多数据源、Druid 与 JDBC/JdbcClient 数据访问示例。 |
| `spring-boot-jpa` | Spring Data JPA 数据持久化示例。 |
| `spring-boot-activemq` | ActiveMQ 消息队列集成示例。 |
| `spring-boot-rabbitmq` | RabbitMQ 消息队列集成示例。 |
| `spring-boot-kafka` | Kafka 消息队列集成示例。 |
| `spring-boot-cache` | Spring Cache 缓存抽象与缓存注解示例。 |
| `spring-boot-mybatis` | MyBatis 数据访问示例。 |
| `spring-boot-mybatis-plus` | MyBatis-Plus 增强数据访问示例。 |
| `spring-boot-flyway` | Flyway 数据库版本管理与迁移示例。 |
| `spring-boot-mapstruct` | MapStruct 对象映射转换示例。 |
| `spring-boot-jasypt` | Jasypt 配置加解密示例。 |
| `spring-boot-knife4j` | Knife4j 集成示例。 |
| `spring-boot-tinylog` | Tinylog 日志框架集成示例。 |
| `spring-boot-schedule` | Spring 定时任务调度示例。 |
| `spring-boot-quartz` | Quartz 任务调度框架集成示例。 |
| `spring-boot-graalvm` | GraalVM / Native Image 相关示例。 |
| `spring-boot-war` | WAR 包部署与外部 Servlet 容器适配示例。 |
| `spring-boot-actuator` | Actuator 监控端点与应用治理示例。 |
| `spring-boot-admin-server` | Spring Boot Admin Server 监控中心示例。 |
| `spring-boot-admin-client` | Spring Boot Admin Client 被监控端接入示例。 |

## :heart: Spring Boot 学习资料

这里分享一份 **Spring Boot 学习资料**，包括 Spring Boot 底层实现原理及代码实战，非常齐全，助你快速打通 Spring Boot 的各个环节。

**详细目录如下：**

- Spring Boot Hello World
- Spring Boot 返回 JSON 数据
- Spring Boot 使用其他 JSON 转换框架
- Spring Boot 全局异常捕捉
- Spring Boot JPA 连接数据库
- Spring Boot 配置 JPA
- Spring Boot 整合 JPA 保存数据
- Spring Boot 使用 JdbcTemplate 保存数据
- Spring Boot 常用配置
- Spring Boot 静态资源处理
- Spring boot 实现任务调度 
- Spring Boot 普通类调用 Bean
- Spring Boot 使用模板引擎
- Spring Boot 集成 JSP
- Spring Boot 集成 Servlet
- Spring Boot 集成 Fliter 和 Listener
- Spring Boot 拦截器 HandlerInterceptor
- Spring Boot 系统启动任务 CommandLineRunner
- Spring Boot 集成 JUnit 单元测试
- Spring Boot 读取系统环境变量
- Spring Boot 使用自定义 properties
- Spring Boot 改变默认包扫描
- Spring Boot 自定义启动 Banner
- Spring Boot 导入 Spring XML 配置文件
- Spring Boot 热部署
- Spring Boot 监控和管理生产环境
- Spring Boot Starter 详解
- Spring Boot 依赖的版本
- Spring Boot 文件上传
- Spring Boot 集成 Redis 缓存
- Spring Boot 之 Spring Cache
- Spring Boot 集成 Ehcache
- Spring Boot 分布式 Session 共享
- ......

**共 108 页！非常齐全！**

**获取方式如下：**

这份教程免费分享给大家，微信扫码关注 **Java技术栈** 公众号：

<p align="center">
  <img src="http://img.javastack.cn/18-11-16/79719805.jpg">
</p>

关注后，在公众号后台发送关键字：**666**，公众号会自助推送给你（非最新教程，仅提供参考学习）。
