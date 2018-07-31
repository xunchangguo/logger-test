FROM registry.c2cloud.cn/library/tomcat8:v2.2

COPY *.war /opt/tomcat/webapps/ROOT.war

# Launch Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]