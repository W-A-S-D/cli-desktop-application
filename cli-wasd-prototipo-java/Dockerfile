FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY nbactions.xml /home/app
WORKDIR /home/app
RUN mvn -Dfile.encoding=UTF-8 clean install

FROM openjdk:11-jre-slim
WORKDIR /usr/local/lib/
COPY --from=build /home/app/target/*-jar-with-dependencies.jar /usr/local/lib/app.jar
ENTRYPOINT [ "sleep", "infinity" ]