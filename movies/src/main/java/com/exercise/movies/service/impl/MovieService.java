package com.exercise.movies.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.exercise.movies.entity.Movie;
import com.exercise.movies.repository.MovieRepository;
import com.exercise.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Date;


@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listMovies(){
        return movieRepository.findAll();
    }

    public ResponseEntity<Movie> findByOid(long oid){
        Optional<Movie> movie = movieRepository.findByOid(oid);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public String createMovie(Movie movie){
        long oid = movieRepository.save(movie).getOid();
        return "Movie created with oid " + oid;
    }

    public String deleteMovieByOid(long oid){
        Optional<Movie> movie = movieRepository.findByOid(oid);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
            return "Movie with id " + oid + " was deleted";
        } else {
            return "Movie with id " + oid + " not found";
        }
    }

    public String deleteMovies(){
        movieRepository.deleteAll();
        return "All movies were deleted";
    }


    public String updateMovieByOid(long oid, Movie updatedMovie){
        Optional<Movie> movie = movieRepository.findByOid(oid);
        if (movie.isPresent()) {
            Movie _movie = movie.get();
            _movie.setTitle(updatedMovie.getTitle() != null ? updatedMovie.getTitle() : _movie.getTitle());
            _movie.setDate(updatedMovie.getDate() != null ? updatedMovie.getDate() : _movie.getDate());
            _movie.setRank(updatedMovie.getRank() != null ? updatedMovie.getRank() : _movie.getRank());
            _movie.setRevenue(updatedMovie.getRevenue() != null ? updatedMovie.getRevenue() : _movie.getRevenue());
            movieRepository.save(_movie);
            return "Movie with id " + oid + " was updated";
        } else {
            return "Movie with id " + oid + " not found";
        }
    }

    public List<Movie> listMoviesFilteredByDate(Date date){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().filter(m -> m.getDate().after(date)).collect(Collectors.toList());
    }

    
}
