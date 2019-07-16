FROM openjdk:8
ADD target/springboot-elasticsearch.jar springboot-elasticsearch.jar
EXPOSE 8080
ENV ELASTICSEARCH_URL="http://elasticsearch:9300"
ENTRYPOINT ["java","-jar","springboot-elasticsearch.jar"]