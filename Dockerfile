# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /TodosApp

# Copy the JAR file into the container
COPY build/libs/TodosApp-0.0.1-SNAPSHOT.jar TodosApp.jar

# Expose the application's port
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "TodosApp.jar"]