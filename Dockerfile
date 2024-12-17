FROM openjdk:17-jdk-slim

ENV PORT=8080

COPY build/libs/todo.jar /app/todo.jar

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "/app/todo.jar", "--server.port=${PORT}"]