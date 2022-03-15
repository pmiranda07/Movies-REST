package com.exercise.movies.servlet;

import java.util.List;

import com.exercise.movies.entity.Movie;
import com.exercise.movies.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

@RestController
@RequestMapping("/api")
public class MovieServlet {

    
    @Autowired
    private IMovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>>listMovies(){
        return new ResponseEntity<>(movieService.listMovies(), HttpStatus.OK);
    }

    @GetMapping("/movies/{movieOid}")
    public ResponseEntity<Movie> getMovie(@PathVariable long movieOid){
        return movieService.findByOid(movieOid);
    }

    @PostMapping("/movies")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/{movieOid}")
    public ResponseEntity<String> deleteMovie(@PathVariable long movieOid){
        return new ResponseEntity<>(movieService.deleteMovieByOid(movieOid), HttpStatus.OK);
    }

    @DeleteMapping("/movies")
    public ResponseEntity<String> deleteMovies(){
        return new ResponseEntity<>(movieService.deleteMovies(), HttpStatus.OK);
    }

    @PutMapping("/movies/{movieOid}")
    public ResponseEntity<String> updateMovie(@PathVariable long movieOid, @RequestBody Movie movie){
        return new ResponseEntity<>(movieService.updateMovieByOid(movieOid, movie), HttpStatus.OK);
    }

    @GetMapping("/movies/filteredByDate")
    public ResponseEntity<List<Movie>>listMoviesByDate(@RequestParam Date date){
        
        return new ResponseEntity<>(movieService.listMoviesFilteredByDate(date), HttpStatus.OK);
    }

    
}
