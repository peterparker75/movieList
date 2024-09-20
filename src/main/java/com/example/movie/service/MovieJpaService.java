/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;
import java.util.*;

@Service
public class MovieJpaService {

    @Autowired
    private MovieJpaRepository movieJpaRepository;

    public List<Movie> getAllMovies() {
        return movieJpaRepository.findAll();
    }

    public Movie getMovieById(int movieId) {
        return movieJpaRepository.findById(movieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }

    public Movie createMovie(Movie movie) {
        return movieJpaRepository.save(movie);
    }

    public Movie updateMovie(int movieId, Movie updatedMovie) {
        Movie movie = getMovieById(movieId);
        movie.setMovieName(updatedMovie.getMovieName());
        movie.setLeadActor(updatedMovie.getLeadActor());
        return movieJpaRepository.save(movie);
    }

    public void deleteMovie(int movieId) {
        getMovieById(movieId); // Ensures exception if movieId is not found
        movieJpaRepository.deleteById(movieId);
    }
}
