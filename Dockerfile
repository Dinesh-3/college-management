FROM openjdk:11
COPY target/*.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
EXPOSE 8761