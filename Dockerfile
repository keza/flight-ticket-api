FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY target/ticket-api-*.jar app.jar
COPY start.sh start.sh

ENTRYPOINT ["sh","start.sh"]
