# Note-Taking sample application


Simple Spring boot app.

## Requirements

For building and running the application you need:

- JDK 1.8
- Maven 3

## Running the application locally

Please see the following ways to run a Spring Boot application on your local machine. 

1. Execute the `main` method in the `com.demo.notes.Application` class from your IDE.

2. Alternatively, you can create an executable JAR file, and run the spring boot application by using the below Maven build −

```shell
mvn clean install
```

After “BUILD SUCCESSFUL”, you can find the JAR file under the build/libs directory. You can run the JAR file by using the command shown below.

```shell
java –jar <JARFILE>
```

This will start the application on the Tomcat port 8080.
Now hit the URL in POSTMAN application and see the output.

You may see the documentation of the API: http://localhost:8000/swagger-ui.html



