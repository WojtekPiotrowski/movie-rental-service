package pl.sda.MovieRental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private StatusOrder statusOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_option")
    private Delivery delivery;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<CopyMovie> copyMovies;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "final_price")
    private BigDecimal price;

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }
}

