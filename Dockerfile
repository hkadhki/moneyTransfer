FROM lippert/adoptopenjdk-17
EXPOSE 5500
ADD target/KP_transfer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]