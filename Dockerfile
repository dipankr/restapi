FROM amazoncorretto:11.0.16-alpine

COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]