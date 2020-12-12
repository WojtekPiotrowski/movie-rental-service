package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*@GetMapping("/user/{userId}/orders")
    ResponseEntity<List<Order>> getAllOrders (@PathVariable("userId") Long userId){
        log.info("reading all orders for given user");
        return ResponseEntity.ok(orderService.findAllOrdersByUserId(userId));
    }*/

    @GetMapping("/orders/{orderId}")
    ResponseEntity<?> getOrderById (@PathVariable("orderId") Long orderId) {
        log.info("reading given order for given user");
        return orderService.findById(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
