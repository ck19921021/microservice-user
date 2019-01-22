cd C:\company\product\paifang\server\api\zuul-product-gateway
call mvn docker:removeImage
call mvn clean package  docker:build -s C:\company\product\apache-maven-3.5.3\conf\settings.xml
mvn clean