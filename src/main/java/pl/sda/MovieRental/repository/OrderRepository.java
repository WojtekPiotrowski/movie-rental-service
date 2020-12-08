package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

public interface OrderRepository extends OrderService, JpaRepository <Order, Long>{
}
