package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository <Order, Long>{

    List<Order> findAll();

    List<Order> findAllOrdersByUserId(Long userId);

    Optional<Order> findById(Long orderId);
}
