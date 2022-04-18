package com.lizgunther.videouniverse.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        int beforeAddingMoreUsers = allUsers.size();

        User user1 = new User();
        user1.setEmail("kdahlin@gmail.com");
        user1.setFirstName("Karin");
        user1.setLastName("Dahlin");
        user1.setPassword("123");
        userService.saveUser(user1);

        int afterAddingMoreUsers = userService.getAllUsers().size();
        Assertions.assertThat(afterAddingMoreUsers).isEqualTo(beforeAddingMoreUsers + 1);
        Assertions.assertThat(allUsers.contains(user1));
    }
}