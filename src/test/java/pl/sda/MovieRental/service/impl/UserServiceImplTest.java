package pl.sda.MovieRental.service.impl;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.MovieRental.exception.NoUserInStockException;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.UserService;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void can_add_new_user() throws Exception {
        //given
        User user = new User();
        user.setUsername("lukasz");
        //when
        User result = userService.save(user);

        //then
        assertEquals(result, user);
    }


    @Test
    void can_find_By_Id() throws NoUserInStockException {
        //given
        User user = new User();
        //when
        userService.save(user);
        Optional<User> result = userService.findById(user.getId());
        //then
        assertEquals(result.hashCode(), user.hashCode());
    }

    @Test
    void can_find_By_Username() {
        //given
        User user = new User();
        user.setUsername("john");
        //when
        userService.save(user);
        Optional<User> result = userService.findByUsername(user.getUsername());
        //then
        assertEquals(result.hashCode(), user.hashCode());


    }

    @Test
    void can_delete_By_Id() {
        //given
        User user = new User();

        //when
        Long userId = userService.save(user).getId();
        userService.deleteById(userId);

        //then
        assertThat(userService.findById(userId)).isEmpty();
    }
}
