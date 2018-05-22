FROM java:8
ADD springfox-swagger-ui-0.0.1-SNAPSHOT.jar springfox-swagger-ui.jar
RUN sh -c 'touch /springfox-swagger-ui.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspringfox.documentation.swagger.v2.path=$API_URL -Djava.security.egd=file:/dev/./urandom -jar /springfox-swagger-ui.jar" ]