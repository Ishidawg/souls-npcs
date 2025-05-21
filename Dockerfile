FROM gradle:8.13-jdk21 AS builder

WORKDIR /home/gradle/project

COPY build.gradle.kts settings.gradle.kts gradlew gradlew.bat HELP.md LICENSE README.md ./
COPY gradle ./gradle

RUN gradle --no-daemon dependencies

COPY src ./src

RUN gradle --no-daemon clean bootJar

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# Test Spring Boot default port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
