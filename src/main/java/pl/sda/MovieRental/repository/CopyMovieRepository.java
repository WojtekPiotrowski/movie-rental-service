package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.CopyMovie;

public interface CopyMovieRepository extends JpaRepository<CopyMovie, Long> {
}
