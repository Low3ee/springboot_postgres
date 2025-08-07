package com.low3ee.webserver.controller;

import com.low3ee.webserver.dto.CreateUserRequest;
import com.low3ee.webserver.dto.LoginRequest;
import com.low3ee.webserver.dto.UserResponse;
import com.low3ee.webserver.entity.User;
import com.low3ee.webserver.service.AuthService;
import com.low3ee.webserver.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request){
        return  ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest reqest) {
        String token = authService.login(reqest);

        return ResponseEntity.ok(Map.of("token", token));
    }
}
