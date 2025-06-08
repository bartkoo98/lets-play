FROM openjdk:21

WORKDIR /app

COPY target/landing-page-service-0.0.1-SNAPSHOT.jar /app/landing-page-service.jar

ENTRYPOINT ["java", "-jar", "landing-page-service.jar"]