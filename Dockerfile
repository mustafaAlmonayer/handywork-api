FROM openjdk:21
EXPOSE 10000
ADD target/handywork-1.0.0-stable.jar handywork-1.0.0-stable.jar
ENTRYPOINT ["java","-jar","/handywork-1.0.0-stable.jar"]
