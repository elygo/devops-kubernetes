FROM openjdk:17-jdk-slim
COPY build/libs/scheduler.jar /app/scheduler.jar
ENTRYPOINT ["java", "-jar", "/app/scheduler.jar"]