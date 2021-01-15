package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.MovieRental.model.Genre;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;


import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
public class MoviesFilterController {

    private final MovieService movieService;

    public MoviesFilterController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movie-list/genres/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenres(@PathVariable("genre") Genre genre) {

        log.info("return movies by genre: " + genre);
        return ResponseEntity
                .ok()
                .body(movieService.findAllByGenre(genre));
    }

    @GetMapping("movie-list/releaseDate")
    public ResponseEntity<List<Movie>> findByReleaseDateBetween(@RequestParam(value = "startDate") String startDate,
                                                                @RequestParam(value = "endDate") String endDate) {

        log.info("return movies by release Date ");
        return ResponseEntity
                .ok()
                .body(movieService.findByReleaseDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }


    //TODO: (AGATA) getMovieByTitle method to prepare

   /* @GetMapping("/movie-list/genres/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenres(@PathVariable("genres") List<Genre> genres) {
        log.info("return movies by genres: " + Arrays.toString(genres.toArray()));
        Optional<Movie> movies = movieService.findByGenres(genreList);
        if(movies.isPresent()) {
            return movies.get();
            //return ResponseEntity.ok(movies.get());
        }
        else {
            return new ArrayList();
        }
    }*/

 /*   @GetMapping("/movie-list/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") Long id) {
        log.info("return movie by ID " + id);
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/
}
