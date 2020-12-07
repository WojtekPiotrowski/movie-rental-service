package pl.sda.MovieRental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CopyMovie {


    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long copyId;

   @ManyToOne
   @JoinColumn(name = "movie_id")
    private Movie movie;
    private boolean available;
}
