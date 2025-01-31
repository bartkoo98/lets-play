FROM openjdk:21

WORKDIR /app

COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/apigateway.jar

ENTRYPOINT ["java", "-jar", "apigateway.jar"]