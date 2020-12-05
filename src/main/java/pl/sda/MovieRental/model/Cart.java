package pl.sda.MovieRental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "copyMovie_id")
    private List<CopyMovie> copyMovies;

    public Cart() {
        this.copyMovies = new ArrayList<CopyMovie>();
    }

    public void addMovie(CopyMovie copyMovie) {
        this.copyMovies.add(copyMovie);
    }
}
