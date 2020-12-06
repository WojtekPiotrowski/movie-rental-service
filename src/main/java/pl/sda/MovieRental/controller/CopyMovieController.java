package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.MovieRental.service.CopyMovieService;


@Slf4j
@Controller
public class CopyMovieController {


    private final CopyMovieService copyMovieService;

    public CopyMovieController(final CopyMovieService copyMovieService) {
        this.copyMovieService = copyMovieService;
    }








}
