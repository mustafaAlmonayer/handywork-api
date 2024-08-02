FROM openjdk:21
EXPOSE 10000
ENTRYPOINT ["java","-jar","/target/handywork-1.0.0-stable.jar"]
