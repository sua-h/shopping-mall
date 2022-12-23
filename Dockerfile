#
FROM openjdk:11-jre-slim-buster
ARG WAR_FILE=build/libs/*.war
COPY ${WAR_FILE} app.war
ENTRYPOINT ["java","-war","/app.war"]
