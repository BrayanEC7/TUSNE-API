# Usa una imagen base de OpenJDK 11 para ejecutar la aplicación
FROM openjdk:17-jdk-alpine

# Metadata del mantenimiento de la imagen
LABEL maintainer="Brayan"

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR construido de tu aplicación Spring Boot desde el directorio build/libs de tu proyecto
#COPY build/libs/*.jar app.jar
COPY build/libs/tusne-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]