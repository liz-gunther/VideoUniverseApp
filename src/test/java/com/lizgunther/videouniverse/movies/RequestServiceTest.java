package com.lizgunther.videouniverse.movies;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestServiceTest {

    private RequestService requestService;

    @Autowired
    public RequestServiceTest(RequestService requestService) {
        this.requestService = requestService;
    }

    @ParameterizedTest
    @ValueSource(strings = {"Milo & Otis", "Kill Bill", "A Serious Man"})
    void saveRequest_should_save_all_new_requests(String string) {
        int numberOfRequestsBeforeTest = requestService.getAllRequests().size();

        Request request = new Request(string);
        requestService.saveRequest(request);

        int numberOfRequestsAfterTest = requestService.getAllRequests().size();
        Assertions.assertThat(numberOfRequestsAfterTest).isEqualTo(numberOfRequestsBeforeTest + 1);
    }
}