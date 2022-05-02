A) Steps to build and run Using Java and Maven:

1. Use following command to build using Maven : mvn clean install
2. Use following command to run the api using Java8(>=java8 should be installed) and above : java -jar target/warehouseapi.jar

B) Steps to build run using docker :
1. Install docker , also to build run following from cmd prompt using maven : mvn compile jib:build
2. Run following from cmd prompt :  docker pull amleshapi/warehouseapi (URL : https://hub.docker.com/r/amleshapi/warehouseapi) 
3. Run following from cmd prompt :  docker run -it -p 8080:8080 amleshapi/warehouseapi

C) Access the warehouse api's :
1. Use following swagger-ui link to see/test the exposed api : http://localhost:8080/warehouse/swagger.html
2. Use following link to see health & metrics of API after running it :
   health :  http://localhost:8080/warehouse/actuator/health
   metrics :  http://localhost:8080/warehouse/actuator/metrics
3. If you are running using Step A as mentioned above then, while application is up and running
   In memory DB can be accessed at : http://localhost:8080/warehouse/h2

D) Tech stacks/features used : 
1. Java 8 - functional way of programming
2. Springboot - creating restful api's with ease of autoconfiguration 
3. Spring data/Jpa - abstraction of Data access from/to Database
4. Maven - automation and build management 
5. Google Jib - create docker image with ease, maven plugin is used
6. Hibernate validator - validation of Bean attributes of requestBody
7. Mapstruct - reduce bolier plate code for spring bean conversion
8. Lombok - reduce boiler plate code for getter, setter, etc.
9. Git - source code version management
10. Docker hub - publish docker image
11. Spring actuator - to expose health and other metrics endpoints
12. H2 database - in memory database
13. Open api specification - documentation of restful api, 
    ready made interface which can be used for exceution of api also.
   