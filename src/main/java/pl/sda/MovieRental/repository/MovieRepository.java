package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Genre;
import pl.sda.MovieRental.model.Movie;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById (Long id);

    Movie findByTitle(String title);

    Movie findByGenre(Genre genre);

}
