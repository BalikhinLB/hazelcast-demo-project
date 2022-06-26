FROM openjdk:17-alpine
COPY target/*.jar app.jar
EXPOSE 5701
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]