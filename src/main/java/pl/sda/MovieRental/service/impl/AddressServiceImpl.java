package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Address;
import pl.sda.MovieRental.repository.AddressRepository;
import pl.sda.MovieRental.service.AddressService;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

private final AddressRepository addressRepository;


    public AddressServiceImpl(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id) {
        addressRepository.save(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}

