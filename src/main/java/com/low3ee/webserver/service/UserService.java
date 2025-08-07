package com.low3ee.webserver.service;

import com.low3ee.webserver.dto.CreateUserRequest;
import com.low3ee.webserver.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest dto);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(String id,  CreateUserRequest dto);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    void deleteUser(String id);
}
