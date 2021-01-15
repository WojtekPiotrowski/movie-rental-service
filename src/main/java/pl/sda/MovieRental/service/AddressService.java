package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<Address> findById(Long id);

    Address save(Address address);

    List<Address> findAll();

}



