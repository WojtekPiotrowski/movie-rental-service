package pl.sda.MovieRental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tittle;
    private LocalDate releaseDate;
    private Genre genre;
    private String description;
    private int rateNumbers; //do sprawdzenia*//
    private double averageRate;
    private int totalCopyNumbers;  //do sprawdzenia*//
    private int availableCopyNumbers; //do sprawdzenia*//
    private BigDecimal price;
}
