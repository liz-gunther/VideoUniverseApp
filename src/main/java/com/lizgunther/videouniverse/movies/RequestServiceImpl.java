package com.lizgunther.videouniverse.movies;

import com.lizgunther.videouniverse.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private UserService userService;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository, UserService userService) {
        this.requestRepository = requestRepository;
        this.userService = userService;
    }

    @Override
    public void saveRequest(Request request) {
        this.requestRepository.save(request);
    }

    @Override
    public Set<Request> getRequestsByUserId(long id) {
        return userService.getUserById(id).getRequests();
    }
}
