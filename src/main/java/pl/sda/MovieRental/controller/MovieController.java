package pl.sda.MovieRental.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<Movie>> getAllMovies(){
        log.info("Return all movie list");
        return ResponseEntity
                .ok()
                .body(movieService.findAll());
    }


    @GetMapping("/movie-list/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") Long id) {
        log.info("return movie by ID " + id);
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    //@CrossOrigin(origins = "http://localhost:3000") //it's necessary if we want to add front
    @PostMapping("/movie-list")
    public ResponseEntity<?> createMovie(@RequestBody final Movie movie) throws Exception {
        log.info("New movie has been created");
        Movie newMovie = movieService.addMovie(movie);
        return ResponseEntity
                .created(URI.create("/" + newMovie.getId()))
                .body(newMovie);
    }


    @DeleteMapping("/movie-list/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {

        if (movieService.findById(id).isPresent()) {
            movieService.deleteById(id);
            log.info("movie " + id + "has been deleted");
            return ResponseEntity
                    .ok()
                    .body(movieService.findById(id));
        } else {
           return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/movie-list/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") Long id, @RequestBody final Movie movie) {

       if( movieService.findById(id).isPresent()) {
           movie.setId(id);
           movieService.save(movie);
           log.info("movie " + movie + "has been updated");
           return ResponseEntity
                   .noContent()
                   .build();
       } else {
       return ResponseEntity.notFound().build();
    }

    }







}
