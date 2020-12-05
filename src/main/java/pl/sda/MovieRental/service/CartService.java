package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Optional<Cart> findCartById (Long id);

    Cart save(Cart cart);

    List<Cart> findAll();

    boolean existsById(Long id);
}
