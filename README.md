# Springboot Json Web Token (JWT) Generation  example
Contributor: **Sohail Nasim**

This project was developed in [Spring Tool Suite](http://spring.io/tools/sts)

## Database

**H2  Embedded (Local) file based Database**

Schema and 'USERS', 'ROLE' and USER_ROLE' tables are generated when Springboot application starts

URL: (http://localhost:8890/h2)

DB Name: useradmindb

Username: sa

Password:


## How to run it
1. You need JDK 1.8 to run this project.
2. Make sure you have [Apache Maven](https://maven.apache.org/download.cgi) installed. Add the bin directory to your PATH.
3. Install the [Git Bash](https://git-scm.com/download) and clone the repository
 from Git Bash
 
```
git clone https://github.com/sohailnasim1/Springboot-Token-Generation-Example.git
 
```

 or download the repository zip file and unzip it to local folder.

Run following command to compile and to create the jar file:

```
cd Springboot-Token-Generation-Example
mvn package

```

How to run Springboot microservices locally:

```
java -jar target/AuthToken-0.0.1-SNAPSHOT.jar
```

## API documentation for Rest service
http://localhost:8890/swagger-ui.html

## Examples

* POST: http://localhost:8890/token/create


**Request:**

Content-Type: application/json

Body:

```
{
	"username":"jdoe",
	"password": "password"
}
```

**Example Respnse**

The generated token is valid for 10 minutes

```
{
    "id": "ae1bbe02-4846-4583-9fea-ba2de7d7fc27",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxNTUxMDUwNjQ4LCJpYXQiOjE1NTEwNTAwNDgsImp0aSI6ImFlMWJiZTAyLTQ4NDYtNDU4My05ZmVhLWJhMmRlN2Q3ZmMyNyJ9.mZdK0cAN0E7ASfFvzWXBAnzkz6yqQjJark9f9OEWkZ05EJqcUEcoxsoVowXwnJaheByTOWrpSG0LST1up8boSQ",
    "expiry": 1551050648985
}
```