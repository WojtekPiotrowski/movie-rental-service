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
    @Column(name = "orderId")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private StatusOrder statusOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_option", nullable = false)
    private Delivery delivery;

    @OneToMany
    @JoinColumn(name = "copyMovie_id")
    private List<CopyMovie> copyMovies;

//    @JoinColumn(name = "create_date")
//    private LocalDateTime createDate;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;
}

