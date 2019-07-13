FROM openjdk:8
ADD target/springboot-mongodb.jar springboot-mongodb.jar
EXPOSE 8080
ENV MONGOCLIENT_DEFAULT_CONNECTION_URL = "mongodb://mongo:27017/employee"
ENTRYPOINT ["java","-jar","springboot-mongodb.jar"]