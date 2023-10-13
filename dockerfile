FROM openjdk:17-jdk-alpine AS build

WORKDIR /app

COPY . /app

RUN maven clean build

FROM openjdk:17-jdk-alpine

EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build target/seekop-0.0.1-SNAPSHOT.jar java-app.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "target/seekop-0.0.1-SNAPSHOT.jar java-app.jar"]