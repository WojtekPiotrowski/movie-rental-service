package pl.sda.MovieRental.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.MovieRental.model.Cart;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class MovieController {


    private final MovieService movieService;


    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }




    @GetMapping("/movie-list")
    public ResponseEntity<List<Movie>> readAllMovies(){
        log.info("Return all movie list");
        return ResponseEntity
                .ok()
                .body(movieService.getAll());
    }

    @GetMapping("/movie-list/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") Long id){
        log.info("return movie by ID " + id);
        return movieService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping("/movie-list")
    public ResponseEntity<?> createMovie(@RequestBody final Movie movie){
        log.info("New movie has been created");
        Movie newMovie = movieService.addMovie(movie);
        return ResponseEntity
                .created(URI.create("/" + newMovie.getId()))
                .body(newMovie);
    }


    @DeleteMapping("/movie-list/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
        movieService.delete(id);
        log.info("movie " + id + "has been deleted");
        return ResponseEntity
                .ok()
                .body(movieService.getById(id));
    }


 /*   @PutMapping("/movie-list/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") Long id){
        log.info("movie " + id + "has been updated");

        return ResponseEntity
                .noContent()
                .build(movieService.update(););
    }
*/


}
