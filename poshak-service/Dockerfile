FROM openjdk:8-jre-alpine

COPY poshak-service/target/poshak-2021.1.war /home/app.war

# for local jenkins
#COPY target/poshak-2021.1.war /home/app.war

CMD ["/usr/bin/java", "-Dspring.profiles.active=prod", "-jar", "/home/app.war"]