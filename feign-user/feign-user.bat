cd C:\company\product\paifang\server\api\feign\feign-qx
call mvn docker:removeImage
call mvn clean package  docker:build -s C:\company\product\apache-maven-3.5.3\conf\settings.xml
mvn clean
