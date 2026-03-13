# 1) Build stage: use Maven + JDK
FROM maven:3.9.7-openjdk-22 AS build
WORKDIR /app

# Copy everything to container
COPY . .

# Build the Spring Boot JAR
RUN mvn clean package -DskipTests

# 2) Run stage: lightweight JDK
FROM openjdk:22-slim
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render uses
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]