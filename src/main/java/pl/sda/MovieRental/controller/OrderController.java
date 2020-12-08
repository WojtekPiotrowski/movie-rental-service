package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.MovieRental.service.OrderService;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/user/{userId}/orders")
    ResponseEntity<?> getAllOrders (@PathVariable("userId") Long userId){
        log.info("reading all orders for given user");
        return orderService.findAllOrdersByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}/orders/{orderId}")
    ResponseEntity<?> getOrderById (@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
        log.info("reading given order for given user");
        return orderService.findByUserIdAndOrderId(userId, orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
