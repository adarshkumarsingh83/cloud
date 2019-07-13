FROM openjdk:8
EXPOSE 8080
ENV SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672"
ADD /target/springboot-rabbitmq.jar springboot-rabbitmq.jar
ENTRYPOINT ["java","-jar","springboot-rabbitmq.jar"]