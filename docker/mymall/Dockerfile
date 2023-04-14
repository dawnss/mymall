FROM openjdk:8-jre
COPY application.yml application.yml
COPY mymall.jar mymall.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mymall.jar"]