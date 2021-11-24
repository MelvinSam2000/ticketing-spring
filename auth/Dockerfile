FROM openjdk:11-jre-slim
RUN adduser --system --group app
USER app:app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]