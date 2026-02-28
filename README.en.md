# spring-boot-best-practice

[中文](./README.md) | English

> :rocket: This repository provides practical Spring Boot examples covering mainstream topics and real development scenarios.
>
> :star: This project will continue to be updated. To stay on track, please click **Star** in the upper-right corner.

## :fire: Why Learn Spring Boot?

> This repository has been adapted to **Spring Boot 4.x**. The current baseline is **Spring Boot 4.0.3**, with **Spring Framework 7.x** and **Java 21**. 
>
> All examples are built around real-world scenarios, making this repository suitable both for learning Spring Boot and for referencing Spring Boot 4.x upgrades and migrations.

Spring has long been one of the most important frameworks in the Java ecosystem. It was once commonly used together with Struts2 and Hibernate as the classic SSH stack for Java Web development. Around 2013, it evolved alongside Spring MVC and MyBatis into the SSM stack, which became the mainstream Java Web development solution for many years.

**To simplify the learning curve of the Spring ecosystem**, Spring Boot was introduced in 2014. It helps developers use Spring components more easily and efficiently. Spring Boot is built on top of Spring, Spring MVC, and related frameworks. It depends on those underlying frameworks rather than existing independently.

Learning Spring Boot makes it easier to master core Spring components, and it is also the foundation for learning Spring Cloud and microservice architecture, **because Spring Cloud is built on top of Spring Boot**.

Spring Boot reflects real enterprise demand. In job descriptions and interview skill lists for Java developers and architects, **Spring Boot is almost always a required skill**. If you want to become a qualified Java engineer and truly understand the Spring ecosystem, Spring Boot is a necessary step.

## :pushpin: Module Overview

This repository uses a Maven multi-module structure and covers core Spring Boot capabilities, data access, messaging middleware, operations and governance, container deployment, and engineering practices. It is designed for both topic-based learning and module-based verification.

| Module Name | Description |
| --- | --- |
| `spring-boot-quick-start` | Quick start and basic bootstrapping example for Spring Boot. |
| `spring-boot-mail` | Email sending example with Spring Boot. |
| `spring-boot-web` | Spring MVC web examples, including message conversion, interceptors, and servlet registration. |
| `spring-boot-webflux` | Reactive development examples with Spring WebFlux and `WebClient`. |
| `spring-boot-logging` | Logging system and logging configuration examples in Spring Boot. |
| `spring-boot-test` | Spring Boot testing examples, including `MockMvc`, `MockBean`, and JSON tests. |
| `javastack-spring-boot-starter` | Example of developing a custom Spring Boot Starter. |
| `javastack-spring-boot-starter-sample` | Example of integrating and using the custom Starter. |
| `spring-boot-properties` | Configuration file, property binding, and custom configuration class examples. |
| `spring-boot-redis` | Redis integration, cache access, and common operation examples. |
| `spring-boot-mongodb` | MongoDB integration and Spring Data MongoDB examples. |
| `spring-boot-elasticsearch` | Elasticsearch integration and Spring Data Elasticsearch examples. |
| `spring-boot-session` | Distributed session management examples with Spring Session. |
| `spring-boot-jetty` | Example of using Jetty as the embedded web container. |
| `spring-boot-docker` | Docker image building, layered packaging, and container deployment examples. |
| `spring-boot-features` | Examples of common Spring Boot features and startup behavior. |
| `spring-boot-application` | Application startup, async invocation, and application-level capability examples. |
| `spring-boot-datasource` | Multi-datasource, Druid, and JDBC/JdbcClient data access examples. |
| `spring-boot-jpa` | Spring Data JPA persistence examples. |
| `spring-boot-activemq` | ActiveMQ integration examples. |
| `spring-boot-rabbitmq` | RabbitMQ integration examples. |
| `spring-boot-kafka` | Kafka integration examples. |
| `spring-boot-cache` | Spring Cache abstraction and cache annotation examples. |
| `spring-boot-mybatis` | MyBatis data access examples. |
| `spring-boot-mybatis-plus` | MyBatis-Plus enhanced data access examples. |
| `spring-boot-flyway` | Flyway database versioning and migration examples. |
| `spring-boot-mapstruct` | Object mapping examples with MapStruct. |
| `spring-boot-jasypt` | Configuration encryption and decryption examples with Jasypt. |
| `spring-boot-knife4j` | Knife4j / OpenAPI integration examples for API documentation. |
| `spring-boot-tinylog` | Tinylog logging framework integration examples. |
| `spring-boot-admin-server` | Spring Boot Admin Server monitoring center example. |
| `spring-boot-admin-client` | Spring Boot Admin Client integration example. |
| `spring-boot-schedule` | Scheduled task examples with Spring scheduling. |
| `spring-boot-quartz` | Quartz scheduler integration examples. |
| `spring-boot-graalvm` | GraalVM / Native Image related examples. |
| `spring-boot-war` | WAR packaging and external servlet container deployment examples. |
| `spring-boot-actuator` | Actuator endpoints and application governance examples. |
| `spring-boot-aop` | Spring AOP examples. |

## :heart: Spring Boot Learning Materials

Here is a complete set of **Spring Boot learning materials**, including underlying implementation principles and practical coding examples, designed to help you quickly master every major aspect of Spring Boot.

**Contents include:**

- Spring Boot Hello World
- Returning JSON data with Spring Boot
- Using alternative JSON libraries in Spring Boot
- Global exception handling in Spring Boot
- Connecting to a database with Spring Boot JPA
- Configuring JPA in Spring Boot
- Saving data with Spring Boot JPA
- Saving data with Spring Boot JdbcTemplate
- Common Spring Boot configuration
- Static resource handling in Spring Boot
- Scheduled tasks in Spring Boot
- Invoking Beans from ordinary classes in Spring Boot
- Using template engines in Spring Boot
- Integrating JSP with Spring Boot
- Integrating Servlets with Spring Boot
- Integrating Filters and Listeners with Spring Boot
- Using `HandlerInterceptor` in Spring Boot
- Startup tasks with `CommandLineRunner`
- Unit testing with Spring Boot
- Reading system environment variables in Spring Boot
- Using custom `properties` in Spring Boot
- Changing the default package scanning path
- Custom startup banners in Spring Boot
- Importing Spring XML configuration files
- Hot deployment in Spring Boot
- Monitoring and managing production environments
- Spring Boot Starter in depth
- Version management in Spring Boot dependencies
- File upload in Spring Boot
- Integrating Redis cache with Spring Boot
- Spring Cache in Spring Boot
- Integrating Ehcache with Spring Boot
- Distributed session sharing in Spring Boot
- ......

**A total of 108 pages, very comprehensive.**

**How to get it:**

This tutorial is shared for free. Scan the QR code below and follow the **Java技术栈** WeChat public account:

<p align="center">
  <img src="http://img.javastack.cn/18-11-16/79719805.jpg">
</p>

After following the account, send the keyword: **666** in the backend, and the public account will automatically deliver the materials to you.
