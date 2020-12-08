package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriBuilder;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.service.CopyMovieService;

import java.net.URI;
import java.util.List;


@Slf4j
@RestController
public class CopyMovieController {


    private final CopyMovieService copyMovieService;

    public CopyMovieController(final CopyMovieService copyMovieService) {
        this.copyMovieService = copyMovieService;
    }


    @PostMapping("/copy-movie-list")
    public ResponseEntity<?> createCopyMovie(@RequestBody final CopyMovie copyMovie){
        log.info("New copy movie has been created" );
        CopyMovie newCopyMovie = copyMovieService.addCopyMovie(copyMovie);
        return ResponseEntity
                .created(URI.create("/" + newCopyMovie.getCopyId()))
                .body(newCopyMovie);
    }


    @GetMapping("/copy-movie-list")
    public ResponseEntity<List<CopyMovie>> getAllCopyMovies() {
        log.info("Return all copy movie list");
        return ResponseEntity
                .ok()
                .body(copyMovieService.findAll());
    }


    @GetMapping("/copy-movie-list/{id}")
    public ResponseEntity<?> getCopyMovieById(@PathVariable("id") Long id){
        log.info("Return copy movie by id " + id);

        return copyMovieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/copy-movie-list/{id}")
    public ResponseEntity<?> deleteCopyMovie(@PathVariable Long id) {

        if (copyMovieService.findById(id).isPresent()) {
            copyMovieService.delete(id);
            log.info("movie " + id + "has been deleted");
            return ResponseEntity
                    .ok()
                    .body(copyMovieService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/copy-movie-list/{id}")
    public ResponseEntity<?> updateCopyMovie(@PathVariable("id") Long id, @RequestBody final CopyMovie copyMovie) {

       if( copyMovieService.findById(id).isPresent()) {
           copyMovie.setCopyId(id);
           copyMovieService.save(copyMovie);
           log.info("Copy movie " + copyMovie + " has been updated");

           return ResponseEntity
                   .noContent()
                   .build();
       } else {
           return ResponseEntity.notFound().build();
       }
    }



}
