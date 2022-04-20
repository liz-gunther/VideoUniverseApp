package com.lizgunther.videouniverse.movies;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RequestServiceImplTest {

    @Autowired
    private RequestService requestService;

    @Test
    void saveRequest() {
        List<Request> allRequests = requestService.getAllRequests();
        int beforeAddingMoreRequests = allRequests.size();


        Request request1 = new Request();
        request1.setRequestName("Office Space");
        requestService.saveRequest(request1);

        int afterAddingMoreRequests = requestService.getAllRequests().size();
        Assertions.assertThat(afterAddingMoreRequests).isEqualTo(beforeAddingMoreRequests + 1);
    }


}