package com.lizgunther.videouniverse.movies;

import java.util.List;
import java.util.Set;

public interface RequestService {

    void saveRequest(Request request);

    Set<Request> getRequestsByUserId(long id);

    List<Request> getAllRequests();
}
