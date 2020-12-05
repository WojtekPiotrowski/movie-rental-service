package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.model.Cart;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.service.CartService;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /*@GetMapping("/carts")
    ResponseEntity<List<Cart>> readAllCarts(){
        log.warn("Exposing all the carts!");
        return ResponseEntity.ok(cartService.findAll());
    }

    @GetMapping("/carts/{id}")
    ResponseEntity<?> readCartById(@PathVariable("id") Long id){
        log.info("reading given cart");
        return cartService.findCartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/carts/{id}/movies")
    ResponseEntity<?> readCartMoviesById (@PathVariable("id") Long id){
        log.info("Reading movies in given cart");
        return cartService.findCartById(id)
                .map(cart -> ResponseEntity.ok(cart.getCopyMovies()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/carts")
    ResponseEntity<Cart> createCart (){
        log.info("Created new empty cart");
        Cart resultCart = cartService.save(new Cart());
        return ResponseEntity.created(URI.create("/"+resultCart.getId())).build();
    }

    @PutMapping(path = "/carts/{id}/addMovie")
    ResponseEntity<?> addMovieToCart (@RequestBody CopyMovie copyMovie, @PathVariable("id") Long id){
        log.info("Adding movie copy to given cart");

        if(!cartService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Cart cart = cartService.findCartById(id).orElse(null);
        cart.setId(id);
        cart.addMovie(copyMovie);
        cartService.save(cart);
        return ResponseEntity.noContent().build();
    }*/


}
