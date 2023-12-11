# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/serviLink-0.0.1-SNAPSHOT.jar /app/serviLink.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "serviLink.jar"]