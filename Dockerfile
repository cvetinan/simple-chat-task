FROM openjdk:11
EXPOSE 8080
COPY ./build/libs/simple-chat-task-0.0.1-SNAPSHOT.jar simple-chat-task-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","simple-chat-task-0.0.1-SNAPSHOT.jar"]