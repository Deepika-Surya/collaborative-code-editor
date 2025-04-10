FROM openjdk:22

WORKDIR /app

# Copy project files for build step
COPY . .

# Build the project inside the container
RUN ./mvnw clean package

# Copy the generated JAR
COPY target/collaborative-code-editor-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
