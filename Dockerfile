FROM openjdk:21

WORKDIR /app

COPY target/user-service-0.0.1-SNAPSHOT.jar /app/userservice.jar

ENTRYPOINT ["java", "-jar", "userservice.jar"]