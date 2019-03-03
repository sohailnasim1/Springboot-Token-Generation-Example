# Springboot JSON Web Token (JWT) Generation  example
Contributor: **Sohail Nasim**

This project was developed in [Spring Tool Suite](http://spring.io/tools/sts)

## Database

**H2  Embedded (Local) file based Database**

Schema and 'USERS', 'ROLE' and USER_ROLE' tables are generated when Springboot application starts first time

Sample data for 'jdoe' user and his 'admin' role will be inserted via src/main/resources/data.sql when application starts first time

URL: (http://localhost:8890/h2)

DB Name: userdb

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

* POST: http://localhost:8890/tokens/create


**Request:**

Content-Type: application/json

Body:

```
{
	"username":"jdoe",
	"password": "password"
}
```

**Example Response**

The generated token was valid for 10 minutes after the creation time and is expired now.
```
{
    "id": "cd84ab81-698f-45c1-a00c-117065ff3e83",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxNTUxNTQ4MDc3LCJpYXQiOjE1NTE1NDc0NzcsImp0aSI6ImNkODRhYjgxLTY5OGYtNDVjMS1hMDBjLTExNzA2NWZmM2U4MyJ9.8au11Dpa-giBIVWpRHfuI8ua_MENwXM9NAC9NKenOIpGoYXUomYInJJW8Pcf7FOvausxWNMpVBft7__poI9qug",
    "issueAt": 1551547477947,
    "expiry": 600
}
```