package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.util.List;

public interface CopyMovieService {


    CopyMovie addCopyMovie(CopyMovie copyMovie);

    CopyMovie getById(Long copyId);

    List<CopyMovie> getAll ();

    void delete(Long copyId);

    void save(CopyMovie copyMovie);

}
