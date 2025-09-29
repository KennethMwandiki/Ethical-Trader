# Integration Service Dockerfile
FROM eclipse-temurin:21-jre AS runtime
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app.jar"]