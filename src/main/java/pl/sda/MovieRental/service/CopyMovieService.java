package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.util.List;
import java.util.Optional;

public interface CopyMovieService {


    CopyMovie addCopyMovie(CopyMovie copyMovie);

    Optional<CopyMovie> findById(Long copyId);

    List<CopyMovie> findAll ();

    void delete(Long copyId);

    void save(CopyMovie copyMovie);

    void saveAll(List<CopyMovie> movies);

    void flush();
}
