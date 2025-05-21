# Use Java 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy built .jar file into container
COPY build/libs/*.jar app.jar

# Expose port 8080 for Spring Boot
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
