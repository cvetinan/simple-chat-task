# Simple chat dummy app
The goal of the application is to build a dummy messaging server (chat server) which communicates over `HTTP`.  
The server expose one endpoint: `POST`: `/messages/{type}`  
For the current example the server should support only 2 types of messages:
- `send_text` (e.g. `http://localhost/messages/send_text`)
- `send_emotion` (e.g. `http://localhost/messages/send_emotion`)

## Build the project
You can build the project using the included Gradle wrapper by running:
- `./gradlew build` on Linux/macOS
- `gradlew build` on Windows

## Run the project
- `./gradlew bootRun` on Linux/macOS
- `gradlew bootRun` on Windows

## Compose up
To run the docker image on port `9090` use:
```
docker-compose -f docker-compose.yml up
```
