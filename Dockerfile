FROM tomee:8-jre-8.0.0-M1-plus
COPY src/main/tomee/conf/system.properties /usr/local/tomee/conf/system.properties
COPY src/main/tomee/conf/tomcat-users.xml /usr/local/tomee/conf/tomcat-users.xml
RUN  rm -rf /usr/local/tomee/webapps/ROOT
ADD  target/ROOT.war /usr/local/tomee/webapps/ROOT.war