/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.movie.service.MovieJpaService;

import com.example.movie.model.Movie;

@RestController
public class MovieController {
    @Autowired
    public MovieJpaService moviejpaService;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return moviejpaService.getMovies();

    }

    @GetMapping("/movies/{movieId}")
    public Movie getById(@PathVariable("movieId") int movieId) {
        return moviejpaService.getById(movieId);

    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return moviejpaService.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return moviejpaService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        moviejpaService.deleteMovie(movieId);

    }
}
