package com.lizgunther.videouniverse.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail_should_return_valid_user_when_email_is_given() {
        User user1 = userRepository.findByEmail("kdahlin@gmail.com");
        Assertions.assertThat(user1.getEmail()).isEqualTo("kdahlin@gmail.com");
    }

    @Test
    void findUserById_should_return_valid_user_when_id_is_given() {
        User user1 = userRepository.findUserById(1L);
        Assertions.assertThat(user1.getId()).isEqualTo(1L);
    }
}