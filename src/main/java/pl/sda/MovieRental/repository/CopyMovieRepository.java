package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.service.CopyMovieService;

@Repository
public interface CopyMovieRepository extends CopyMovieService, JpaRepository<CopyMovie, Long> {
}
