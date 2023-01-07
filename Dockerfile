#
FROM openjdk:8-jdk
ARG JAR_FILE=target/shoppingmall-21.5.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
