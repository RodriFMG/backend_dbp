FROM openjdk:22
COPY target/HACK_2-0.0.1-SNAPSHOT.jar prueba.jar
CMD ["java", "-jar", "prueba.jar"]