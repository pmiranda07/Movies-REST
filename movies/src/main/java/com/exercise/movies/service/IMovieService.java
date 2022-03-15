package com.exercise.movies.service;

import java.util.List;
import com.exercise.movies.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Date;

@Service
public interface IMovieService {

    List<Movie> listMovies();
    ResponseEntity<Movie> findByOid(long oid);
    String createMovie(Movie movie);
    String deleteMovieByOid(long oid);
    String deleteMovies();
    String updateMovieByOid(long oid, Movie updatedMovie);
    List<Movie> listMoviesFilteredByDate(Date date);


    
}
