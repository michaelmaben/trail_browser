FROM openjdk

COPY target/californiatrails-0.0.1-SNAPSHOT.jar /deployments/
CMD java -jar deployments/californiatrails-0.0.1-SNAPSHOT.jar
