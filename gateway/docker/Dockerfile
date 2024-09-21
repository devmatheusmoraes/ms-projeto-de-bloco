FROM amazoncorretto:17
LABEL maintainer='matheuxmoraes'
LABEL ambiente='producao'
EXPOSE 9098
WORKDIR /app
COPY gateway-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]