FROM maven:3.8.1-openjdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
EXPOSE 5000
RUN mkdir /app
COPY --from=build /home/app/target/calculator-0.0.1-SNAPSHOT.jar /app/calculator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/calculator-0.0.1-SNAPSHOT.jar"]
