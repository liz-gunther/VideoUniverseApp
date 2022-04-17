package com.lizgunther.videouniverse.security;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User findByEmail(String email);

}
