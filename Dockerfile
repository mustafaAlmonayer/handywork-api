FROM openjdk:17
EXPOSE 8080
ADD target/handywork-1.0.0-stable.jar handywork-1.0.0-stable.jar
ENTRYPOINT ["java","-jar","/handywork-1.0.0-stable.jar"]
