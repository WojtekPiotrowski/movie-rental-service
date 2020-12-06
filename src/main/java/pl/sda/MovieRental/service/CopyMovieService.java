package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

public interface CopyMovieService {

    void save(CopyMovie copyMovie);

    CopyMovie getById(Long copyId);

    void delete(Long copyId);

    void update (CopyMovie copyMovie);


}
