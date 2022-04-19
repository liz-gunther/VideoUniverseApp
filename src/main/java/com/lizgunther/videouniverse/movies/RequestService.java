package com.lizgunther.videouniverse.movies;

import java.util.Set;

public interface RequestService {

    void saveRequest(Request request);

    Set<Request> getRequestsByUserId(long id);
}
