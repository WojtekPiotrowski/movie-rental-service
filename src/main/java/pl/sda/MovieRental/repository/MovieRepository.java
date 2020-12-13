package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Genre;
import pl.sda.MovieRental.model.Movie;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById (Long id);

    Optional<Movie> findByTitle(String title);

    List<Movie> findAllByGenre(Genre genre);

    List<Movie> findByReleaseDateBetween(LocalDate releaseDate1, LocalDate releaseDate2);



}
