
package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieJpaService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{movieId}")
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie movie) {
        return movieService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
    }
}
