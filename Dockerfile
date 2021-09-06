FROM openjdk:16-jdk-alpine
COPY . /
RUN ./gradlew build
ENTRYPOINT ["java","-jar","./build/libs/TaskForAlfaBank-0.0.1-SNAPSHOT.jar"]
