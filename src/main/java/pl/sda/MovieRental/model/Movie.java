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

    @OneToMany
    private List<CopyMovie> copies;
}
