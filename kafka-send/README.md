```bash
mvn clean package spring-boot:repackage
podman build . --tag kafka-send
```