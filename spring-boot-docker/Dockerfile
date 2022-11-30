# 分别放开以下注释，并修改 application.yml 中对应的端口

# 整包构建
#FROM eclipse-temurin:17-jre
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} application.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application.jar"]
#EXPOSE 8080

# 分层构建
#FROM eclipse-temurin:17-jre as builder
#WORKDIR application
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} application.jar
#RUN java -Djarmode=layertools -jar application.jar extract
#
#FROM eclipse-temurin:17-jre
#WORKDIR application
#COPY --from=builder application/dependencies/ ./
#COPY --from=builder application/spring-boot-loader/ ./
#COPY --from=builder application/snapshot-dependencies/ ./
#COPY --from=builder application/application/ ./
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
#EXPOSE 8081
