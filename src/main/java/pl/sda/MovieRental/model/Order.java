package pl.sda.MovieRental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_Id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private StatusOrder statusOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_option", nullable = false)
    private Delivery delivery;

    @OneToMany
    @Column(name = "copy_movie_list")
    private List<CopyMovie> copyMovies;

//    @JoinColumn(name = "create_date")
//    private LocalDateTime createDate;
}

