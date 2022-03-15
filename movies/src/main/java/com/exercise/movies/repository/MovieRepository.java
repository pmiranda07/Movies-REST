package com.exercise.movies.repository;

import java.util.List;
import java.util.Optional;

import com.exercise.movies.entity.Movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    
    List<Movie> findAll();

    Optional<Movie> findByOid(long oid);
}
