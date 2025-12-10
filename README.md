# Location Tracking Backend

Spring Boot REST API for location tracking application.

## Technologies

- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## API Endpoints

- `POST /api/locations` - Save a new location
- `GET /api/locations` - Get all locations
- `GET /api/locations/recent` - Get 10 most recent locations
- `GET /api/locations/{id}` - Get location by ID

## Running the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using Maven wrapper from root
cd ..
./mvnw spring-boot:run -f backend/pom.xml
```

Server runs on: `http://localhost:8080`

## Database

H2 in-memory database console: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:locationdb`
- Username: `sa`
- Password: (empty)

## Configuration

See `src/main/resources/application.properties` for configuration options.
