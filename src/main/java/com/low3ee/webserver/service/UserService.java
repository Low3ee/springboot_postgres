package com.low3ee.webserver.service;

import com.low3ee.webserver.dto.CreateUserRequest;
import com.low3ee.webserver.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest dto);
    UserResponse getUserById(String id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(String id,  CreateUserRequest dto);

    void deleteUser(String id);
}
