FROM openjdk:17-jdk-slim

ENV PORT=8090

COPY build/libs/pong.jar /app/pong.jar

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "/app/pong.jar", "--server.port=${PORT}"]