FROM tomcat:8.0.17-jre8

RUN rm -rf /usr/local/tomcat/webapps/*
ADD vulnerable-application/target/log4shell-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080 
CMD ["catalina.sh", "run"]
