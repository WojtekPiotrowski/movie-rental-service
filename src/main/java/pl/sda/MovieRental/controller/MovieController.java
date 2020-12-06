package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.MovieRental.model.Cart;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;

import java.net.URI;
import java.util.List;

@Slf4j
@Controller
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
        log.info("return movie by ID" + id);
        return movieService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }





 /*   @GetMapping("movie-list/{movieId}")
    public String deleteMovie(@PathVariable Long movieId){


        movieService.delete(movieId);
        log.info("Movie" + movieId + "has been deleted");

        return "redirect:/movie-list";
    }
*/



}
