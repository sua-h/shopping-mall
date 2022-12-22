#
#FROM openjdk:11-jre-slim-buster
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM maven:3.8.1-jdk-11
ADD ./springboot-server-start.sh app.sh
ENTRYPOINT ["/bin/sh","app.sh"]