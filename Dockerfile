FROM openjdk:8
COPY ./target/favorito-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/src/favorito/
WORKDIR /usr/src/favorito
EXPOSE 8080
CMD ["java", "-jar", "favorito-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
