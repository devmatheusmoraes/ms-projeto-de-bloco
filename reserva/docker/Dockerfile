FROM amazoncorretto:17
LABEL maintainer='matheuxmoraes'
LABEL ambiente='producao'
WORKDIR /app
COPY reserva-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]