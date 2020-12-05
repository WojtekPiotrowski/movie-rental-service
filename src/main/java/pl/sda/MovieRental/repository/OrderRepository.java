package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

@Repository
public interface OrderRepository extends OrderService, JpaRepository <Order, Long>{
}
