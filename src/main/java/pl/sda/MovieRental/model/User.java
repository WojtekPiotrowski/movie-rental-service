package pl.sda.MovieRental.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    @OneToMany (mappedBy = "user")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Address address;
}
