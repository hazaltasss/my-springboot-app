This project provides a RESTful API for basic CRUD (Create, Read, Update, Delete) operations using Spring Boot and MySQL. The application is built on an MVC (Model-View-Controller) architecture to streamline data management.

### About the Project
The application supports adding, updating, listing, and deleting data through API endpoints. With the flexibility of Spring Boot and compatibility with MySQL, this project offers a solid foundation for scalable development.

### Project Structure
- **Controller**: Handles HTTP requests and manages API endpoints, passing requests to the Service layer.
- **Service**: Contains business logic, coordinates database operations, and applies data validation and business rules.
- **Repository**: Manages communication with the MySQL database using Spring Data JPA, containing the queries for database operations.
- **DTO (Data Transfer Object)**: Optimizes data transfer between layers, ensuring security and speed.
- **Exception Handling**: Provides meaningful error messages to users through custom exception handling structures.

### Features
- **Spring Boot Framework**: Comprehensive configuration options for rapid development.
- **MySQL Integration**: Seamless data management with MySQL database support.
- **RESTful API**: Uses HTTP methods like GET, POST, PUT, and DELETE for data management.
- **Modular Structure**: Organized with MVC architecture, ensuring a clean and maintainable codebase.

### Running the Application
To start the application, use Maven with the following command:

```bash
mvn spring-boot:run
