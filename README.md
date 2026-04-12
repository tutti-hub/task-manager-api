# Task Manager API

Simple REST API for managing users and tasks (mini Jira-like system).

## Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Gradle

## Features

* User management (create, get)
* Task management (CRUD)
* Validation
* Global exception handling
* Pagination (for tasks)

## Project Structure

src/main/java/com/jjtutti/taskmanager

* controller
* service
* repository
* entity
* dto
* mapper
* exception

## How to Run

1. Clone the repository:
   git clone https://github.com/yourname/task-manager-api.git

2. Configure database in `application.yml` or `application.properties`

3. Run the application:
   ./gradlew spring-boot:run

## API Endpoints

### Users

* POST /users — create user
* GET /users/{id} — get user by id

### Tasks

* POST /tasks — create task
* GET /tasks — get all tasks (with pagination)
* PUT /tasks/{id} — update task
* DELETE /tasks/{id} — delete task

## Notes

This project was built as a learning project to practice backend development with Spring Boot and REST APIs.

## Future Improvements

* Authentication (JWT)
* Role-based access
* Docker support
* Unit & integration tests

