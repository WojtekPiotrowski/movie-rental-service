package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Address;

import java.util.List;

public interface AddressService {

    Address findById(Long id);
    void update(Long id);
    Address save(Address address);
    List<Address> getAll();

}



