FROM openjdk:17-jdk-slim
COPY build/libs/scheduler.jar /app/scheduler.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/scheduler.jar"]