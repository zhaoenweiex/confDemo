FROM waylau/docker-spring-boot
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
ADD ext/conf/hyConfig.xml ext/conf/demoConf.xml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]