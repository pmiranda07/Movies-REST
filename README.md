# Movie REST API

### To run the application you need:

- Java 11

### How to run

- Go to directory */Movies-REST/movies*
- Run the command *./mvnw spring-boot:run*

### CRUD operation

- **GET** */api/movies* ->  list all existing movies
- **GET** */api/movies/{movieOid}* -> lists the movie with id *movieOid*
- **GET** */api/movies/filteredByDate?date=YYYY-MM-DD* -> lists all movies launched after date (expects date as a param)
- **POST** */api/movies* -> creates a movie (expects a movie object in body)
- **DELETE** */api/movies/{movieOid}* -> deletes the movie with id *movieOid*
- **DELETE** */api/movies* -> deletes all existing movies
- **PUT** */api/movies/{movieOid}* -> updates the movie with it *movieOid* (expects a movie object in body)

### H2 Database console access

- Access on */h2-console*
- JBDC URL: *jdbc:h2:mem:moviesdb*
- Username: *admin*
- Password: *movies*

