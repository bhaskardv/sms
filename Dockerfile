FROM  openjdk:8-jdk

ADD target/sms-1.0.jar /

ADD application.properties /

ADD keystore.p12 /

ENTRYPOINT ["java","-jar","/sms-1.0.jar","--spring.config.location","/application.properties"]

EXPOSE 443

EXPOSE 80
