FROM openjdk:21-jdk-slim AS final

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]