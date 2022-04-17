package com.lizgunther.videouniverse.security;


public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    User save(UserRegistrationDto userDto);


}
