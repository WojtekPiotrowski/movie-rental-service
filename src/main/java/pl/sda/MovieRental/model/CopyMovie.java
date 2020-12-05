package pl.sda.MovieRental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CopyMovie {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int copyId;
    private int movieId;
    private boolean available;
}
