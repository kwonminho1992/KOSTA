FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} docker2.jar
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/docker2.jar"]