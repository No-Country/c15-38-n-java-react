# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-alpine
COPY --from=build /target/serviLink-0.0.1-SNAPSHOT.jar serviLink.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "serviLink.jar"]