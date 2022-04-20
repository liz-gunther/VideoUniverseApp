package com.lizgunther.videouniverse.movies;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;

    @Test
    void getRequestById() {
        Request request = requestRepository.getRequestById(2);
        Assertions.assertThat(request.getId()).isEqualTo(2);
    }
}