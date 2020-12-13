package pl.sda.MovieRental.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.MovieRental.model.Address;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.AddressService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findById() {
//        //given
//        Address address = new Address();
//        User user = new User();
//
//        address.setUser(user);
//        //when
//
//        Address savedAddress = addressService.save(address);
//
//        Optional<Address> result = addressService.findById(savedAddress.getId());
//        //then
//        assertEquals(result.hashCode(),savedAddress);


    }
    @Test
    void can_add_new_address() {
        //given
        Address address = new Address();
        //when
       Address result = addressService.save(address);
        //then
        assertEquals(result, address);
    }
        @Test
        void getAll () {
            //given
//            Address address = new Address();
//            //when
//            Address result = addressService.save(address);
//            //then
//            assertEquals(result, address);

        }
    }