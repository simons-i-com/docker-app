FROM tomcat:10-jdk17
ADD target/docker-app-1.0-SNAPSHOT.war   /usr/local/tomcat/webapps/docker-app-1.0-SNAPSHOT.war
EXPOSE 8080
CMD ["catalina.sh","run"]