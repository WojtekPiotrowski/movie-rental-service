package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Cart;
import pl.sda.MovieRental.service.CartService;

@Repository
public interface CartRepository extends CartService, JpaRepository<Cart, Long> {
}
