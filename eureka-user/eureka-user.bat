cd C:\product\backend\microservice-user\eureka-user
call mvn docker:removeImage
call mvn clean package  docker:build -s C:\tool\apache-maven-3.5.3\conf\settings.xml
mvn clean