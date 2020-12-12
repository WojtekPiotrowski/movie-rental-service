package pl.sda.MovieRental.service.impl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.UserService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
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
    void can_delete_by_id() {
        //given
        User user = new User();

        //when
        Long userId = userService.save(user).getId();
        userService.deleteById(userId);

        //then
        assertThat(userService.findById(userId)).isEmpty();
    }
}
