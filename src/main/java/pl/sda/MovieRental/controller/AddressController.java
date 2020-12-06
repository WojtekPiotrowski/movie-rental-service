package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.model.Address;
import pl.sda.MovieRental.service.AddressService;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> readAllAddress() {
        log.info("Return all address list");
        return ResponseEntity
                .ok(addressService.getAll());
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("address/address-list")
    public ResponseEntity<Address> createAddress(@RequestBody final Address address) {
        Address newAddress = addressService.save(address);
        log.info("New address has been created");
        return ResponseEntity
                .created(URI.create("/" + newAddress.getId()))
                .body(newAddress);
    }
//       @PutMapping("/address-list/{id}")
//    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id){
//        log.info("address " + id + "has been updated");
//        return ResponseEntity
//                .noContent()
//                .build(addressService.update());
//    }

}
