# 仓库开发指引

## 1. 沟通与输出

- 默认使用中文沟通、分析和提交说明。
- 这是一个示例型仓库，优先保证示例清晰、可运行、便于教学，不要为了“工程化完美”随意重构现有写法。
- 修改时遵循最小改动原则，尽量只影响目标模块，避免跨模块连带调整。

## 2. 项目定位

- 仓库名：`spring-boot-best-practice`
- 目标：沉淀 Spring Boot 主流知识点实战示例，同时作为 Spring Boot 4.x 升级与迁移参考。
- 结构：Maven 多模块聚合工程，根模块只做依赖/插件/模块管理，各子模块基本可独立演示一个主题。

## 3. 技术基线

- JDK：25
- Spring Boot：4.x
- Spring Framework：7.x
- 构建工具：Maven（仓库未提供 Maven Wrapper，默认直接使用本机 `mvn`）
- 常见公共依赖：Lombok、`spring-boot-starter-webmvc`、`commons-lang3`、DevTools、`spring-boot-configuration-processor`

## 4. 模块地图

### 基础与 Web

- `spring-boot-quick-start`：快速入门
- `spring-boot-application`：启动与应用级能力
- `spring-boot-web`：Spring MVC、消息转换、拦截器、Servlet/Filter 注册
- `spring-boot-webflux`：WebFlux、`WebClient`
- `spring-boot-properties`：配置绑定、Profile、配置导入
- `spring-boot-logging`：日志体系
- `spring-boot-test`：测试能力
- `spring-boot-aop`：AOP 示例
- `spring-boot-mail`：邮件发送
- `spring-boot-features`：常见特性与启动行为
- `spring-boot-jetty`：Jetty 容器
- `spring-boot-war`：WAR 部署

### 数据访问与缓存

- `spring-boot-datasource`：多数据源、Druid、JDBC/JdbcClient
- `spring-boot-jpa`：Spring Data JPA
- `spring-boot-mybatis`：MyBatis
- `spring-boot-mybatis-plus`：MyBatis-Plus
- `spring-boot-flyway`：数据库迁移
- `spring-boot-mapstruct`：对象映射
- `spring-boot-cache`：Spring Cache
- `spring-boot-redis`：Redis
- `spring-boot-mongodb`：MongoDB
- `spring-boot-elasticsearch`：Elasticsearch
- `spring-boot-session`：Spring Session

### 消息与调度

- `spring-boot-activemq`：ActiveMQ
- `spring-boot-rabbitmq`：RabbitMQ
- `spring-boot-kafka`：Kafka
- `spring-boot-schedule`：Spring 调度
- `spring-boot-quartz`：Quartz 调度

### 运维、部署与扩展

- `spring-boot-docker`：Docker/容器化
- `spring-boot-actuator`：Actuator
- `spring-boot-admin-server`：监控中心
- `spring-boot-admin-client`：被监控端
- `spring-boot-graalvm`：GraalVM / Native Image
- `spring-boot-jasypt`：配置加解密
- `spring-boot-knife4j`：Knife4j
- `spring-boot-tinylog`：Tinylog
- `javastack-spring-boot-starter`：自定义 Starter
- `javastack-spring-boot-starter-sample`：Starter 接入示例

## 5. 代码与目录习惯

- 包名前缀统一使用 `cn.javastack.springboot.<module>`
- 各模块入口类通常直接命名为 `Application`
- 典型分层命名：
  - Web：`controller`、`config`、`handler`、`servlet`、`bean`
  - 数据：`entity`、`dto`、`dao`、`mapper`、`repo`
  - 配置：`*Config`、`*Properties`
- 对象命名沿用现有风格：`*DO`、`*DTO`、`*Properties`
- 配置文件优先使用 `application.yml`
- 测试代码放在标准 Maven 目录，使用 JUnit 5

## 6. 编码风格

- 延续现有“示例优先”风格：代码简洁直接，避免无必要的抽象层。
- 广泛使用 Lombok，如 `@Data`、`@Slf4j`、`@RequiredArgsConstructor`。
- 依赖注入优先与现有模块保持一致；新代码优先使用构造器注入。
- Web 示例中允许直接返回对象、字符串或 `ResponseEntity`，以突出框架能力演示。
- 注释可保留中文，必要时可沿用“作者/公众号”风格的简短类注释。
- 不要主动把现有示例统一重写成 record、MapStruct 全覆盖、或完全现代化 API，除非用户明确要求。
- 对已有历史细节保持兼容，例如包名中的既有拼写、示例接口路径、简单 DTO/DO 建模方式，不要顺手重命名。

## 7. 配置与环境注意事项

- 很多模块依赖本地中间件，请先确认对应服务是否已启动：MySQL、Redis、MongoDB、Elasticsearch、ActiveMQ、RabbitMQ、Kafka。
- `spring-boot-datasource` 默认使用本地 MySQL：`jdbc:mysql://localhost:3306/javastack`，用户名 `root`，密码 `12345678`，并自动执行初始化 SQL。
- `spring-boot-web` 默认启用 HTTPS，端口 `8443`，使用类路径下 `.keystore`。
- `spring-boot-properties` 演示了多 Profile、Profile Group 和外部配置导入，改动配置时注意不要破坏示例覆盖面。
- 自定义 Starter 相关改动，除 Java 配置类外，还要同步关注 `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`；仓库中也保留了 `spring.factories`。

## 8. 常用命令

- 全量构建：`mvn clean test`
- 跳过测试和镜像打包：`mvn clean package -DskipTests -Dspring-boot.build-image.skip=true`
- 仅构建单模块：`mvn -pl spring-boot-web -am test`
- 运行单模块：`mvn -pl spring-boot-web spring-boot:run`
- 运行指定入口类时，优先在目标模块目录内执行 Maven 命令，减少其他模块干扰。

## 9. 后续协作默认策略

- 先确认需求落在哪个模块，再做局部修改。
- 新增示例时，优先复用当前模块已有包结构与命名。
- 如果需求跨多个主题，优先拆成多个模块内的独立改动，不把示例强行揉成一个“大而全”实现。
- 当代码发生变更时，默认评估是否需要同步更新相关 `README` 文档以及 `AGENTS.md`，避免文档和代码脱节。
- 除非用户明确要求，否则不要顺手清理无关代码、升级大版本依赖、或统一改写仓库风格。
