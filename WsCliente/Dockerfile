### CREACION DE JAR ###
FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:go-offline
COPY src ./src
RUN cd /app && mvn -e -B package -Dmaven.test.skip=true

#### EJECUCION DEL JAR ####
FROM openjdk:8-jdk-alpine

RUN apk --no-cache add curl

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

#COPY ./target/api*.jar /app.jar
COPY --from=builder /app/target/*.jar /app.jar

ENV host="postgres11_tienda"
ENV database="tienda"
ENV username="postgres"
ENV password="postgres123"
ENV urlcliente = "http://wsproductos:8081"

ENTRYPOINT exec java -jar /app.jar
EXPOSE 8082