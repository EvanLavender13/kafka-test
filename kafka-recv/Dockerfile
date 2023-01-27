FROM docker.io/openjdk:11
WORKDIR /app/
COPY ./target/kafka-recv-1.0-SNAPSHOT.jar /app/
CMD ["java", "-jar", "kafka-recv-1.0-SNAPSHOT.jar"]
# CMD ["bash"]