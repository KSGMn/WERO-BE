FROM eclipse-temurin:17-jdk-alpine
COPY ./build/libs/*SNAPSHOT.jar We-Ro-SNS.jar
ENTRYPOINT ["java", "-jar", "We-Ro-SNS.jar"]