package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.service.CopyMovieService;

public interface CopyMovieRepository extends CopyMovieService, JpaRepository<CopyMovie, Long> {
}
