FROM amazoncorretto:17
LABEL maintainer='matheuxmoraes'
LABEL ambiente='producao'
EXPOSE 8761
WORKDIR /app
COPY eureka-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]