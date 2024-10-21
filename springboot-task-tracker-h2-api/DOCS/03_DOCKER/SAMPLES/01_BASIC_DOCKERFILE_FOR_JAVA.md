


```bash
# Name this image like  springboot-todo-h2-api-docker-basic
# Previous build the docker image execute the following steps
# 1.  mvn clean package

FROM openjdk:17
EXPOSE 8080

# Create app directory
WORKDIR /usr/src/app
ADD target/task-tracker-docker.jar /usr/src/app/task-tracker-docker.jar

ENTRYPOINT ["java", "-jar", "task-tracker-docker.jar" ]
```