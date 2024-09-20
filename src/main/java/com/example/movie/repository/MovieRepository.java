package com.example.movie.repository;

import java.util.*;
import com.example.movie.model.Movie;

public interface MovieRepository {
    List<Movie> findAll();

    Optional<Movie> findById(int movieId);

    Movie save(Movie movie);

    void deleteById(int movieId);
}
