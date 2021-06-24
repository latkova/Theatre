**Theatre** (_project is still in progress_)

This project is the implementation of online service for internal usage of entertainment company, whose functions are selling tickets for different kinds of shows.
It includes registration of users, adding tickets in shopping cart for various performances. 

Implementation details and technologies
The project has an N-tier structure and consists of the database layer, the DAO layer for interaction with the database, the service layer which contains the business logic, and the presentation layer.
All the architecture is built on REST-principles, with the help of Hibernate and Spring frameworks.

**Technologies**


Apache Tomcat - version 9.0.46
MySQL - version 8.0.24
Hibernate - version 5.4.27.Final
Spring - version 5.3.3

**Configuration**


Clone this project into your local folder and open the project in an IDE.

Configure Tomcat Server and set up the MySQL RDBMS on your machine.

Insert your own MySQL username and login in dbProperties in the resources package.

Setup new connection with:

user: "your username"
password: "your password"
url: jdbc:mysql://xxxx:yyyy/kkkk?serverTimezone=UTC , where:
xxxx - host name,
yyyy - port,
kkkk - database name
Run a project "# Theatre"
