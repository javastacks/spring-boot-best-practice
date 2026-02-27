# 用法：
# 1) 整包镜像：docker build --target all-in-one -t javastack/docker-all:1.0 .
# 2) 分层镜像：docker build --target layered -t javastack/docker-layer:1.0 .

# =========================
# 整包镜像（all-in-one）
# =========================
FROM eclipse-temurin:21-jre AS all-in-one
ARG JAR_FILE=target/*-exec.jar
COPY ${JAR_FILE} /application.jar
ENV SPRING_PROFILES_ACTIVE=docker-all
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application.jar"]
EXPOSE 8080

# =========================
# 分层镜像（layered）
# =========================
FROM eclipse-temurin:21-jre AS builder
WORKDIR /builder
ARG JAR_FILE=target/*-exec.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

FROM eclipse-temurin:21-jre AS layered
WORKDIR /application
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ .//
ENV SPRING_PROFILES_ACTIVE=docker-layered
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8081
