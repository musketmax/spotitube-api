# Spotitube API 
This assignment contains the following parts:
* Spotitube Java implementation with Unit Tests
* Documentation with UML diagrams
* SQL Create and Insert scripts

## Setup
* Run the SQL Scripts on MySQL (local or somewhere else)
* Update the `database.properties` file in `src/main/resources/database.properties` with your own database connection string and driver (leave the queries placed there, they are there so the queries can be easily switched)
* Setup TomEE Plus within IntelliJ IDEA to build and deploy the spotitube `.war` file.
* Test if it's running correctly by visiting the URL, which should display a welcome message showing you that it's running.

## Running
* Connect the deployed Spotitube API to the Spotitube Angular Client, which is located at `http://ci.icaprojecten.nl/spotitube/`. Insert the connection string, something like `http://localhost:8080/spotitube`. The default users with paswords in the SQL script are: 

```
username: "admin"
password: "password"

username: "user"
password: "password"
```

## Testing
* Click the `Run tests with coverage` button in IntelliJ IDEA to run all tests with coverage.
