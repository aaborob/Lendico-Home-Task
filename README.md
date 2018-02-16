
[![Build Status](https://travis-ci.org/aaborob/Lendico-Home-Task.svg?branch=master)](https://travis-ci.org/aaborob/Lendico-Home-Task)
# Lendico Home Test
- Author: Ahmad Naser
- Email: ahmad.aborob94@gmail.com
- Phone: +962795835052

### Lendico Home Test Challenge
A Spring Boot application for Lendico Home Test, uses Continuous Integration, with Travis & Heroku. Also the application uses Swagger documentaion for the endpoints.
For running the application you only need to have Maven and Java 8 installed on your machine.
- The application is deployed on Heroku, you can access Swagger UI here: https://lendico-home-test.herokuapp.com/swagger-ui.html

### Summary
- I created one controller that calls a service to generate the plan based on the passed Loan object and returns an installments array.

### Dependencies for deployment on local machine
- Maven
- Java 8

Run the Application:

```
mvn spring-boot:run
```

