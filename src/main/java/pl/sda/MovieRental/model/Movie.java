package pl.sda.MovieRental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String title;
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String description;
    private int numberOfRatings;
    private double averageRating;
    private BigDecimal price;


    @OneToMany (cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<CopyMovie> copies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return title.getClass().hashCode();
    }
}
