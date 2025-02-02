FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /home/app
COPY . /home/app

# Build the project
RUN mvn clean package -DskipTests

# Use Java 21 runtime
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /home/app
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]