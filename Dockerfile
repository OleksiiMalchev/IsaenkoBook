FROM amazoncorretto:17.0.5
COPY ./target/isaenkobook.jar isaenkobook.jar
EXPOSE 8080
CMD ["java","-jar","isaenkobook.jar"]
HEALTHCHECK --interval=10s CMD "curl -f http://localhost:8080/actuator/health || exit"