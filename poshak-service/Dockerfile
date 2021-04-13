FROM openjdk:8-jre-alpine

COPY target/poshak-2021.1.war /home/app.war

CMD ["/usr/bin/java", "-jar", "-Dspring.data.mongodb.uri=\"mongodb+srv://test:test@cluster0.ndd9h.mongodb.net/test?retryWrites=true&w=majority\" ", "/home/app.war"]