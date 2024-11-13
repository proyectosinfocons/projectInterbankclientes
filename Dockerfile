FROM maven:3.8.6-openjdk-17-slim AS MVN_M2
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

# Mostrar el contenido del directorio de salida
RUN ls /build/target/

# Etapa de ejecución con OpenJDK 17
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=MVN_M2 /build/target/projectInterbankclientes-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "projectInterbankclientes-0.0.1-SNAPSHOT.jar"]