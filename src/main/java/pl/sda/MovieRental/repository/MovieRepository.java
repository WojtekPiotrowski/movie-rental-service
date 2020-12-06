package pl.sda.MovieRental.repository;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Genre;
import pl.sda.MovieRental.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {



    Movie findByTitle(String title);

    Movie findByGenre(Genre genre);




}
