package pl.sda.MovieRental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private StatusOrder statusOrder;
    private Delivery delivery;

    @OneToOne
    @JoinTable(name = "order_cart",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Cart cart;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;

}

