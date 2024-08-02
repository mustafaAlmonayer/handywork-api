FROM openjdk:21
COPY --from=/target/handywork-1.0.0-stable.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java","-jar","app.jar"]
