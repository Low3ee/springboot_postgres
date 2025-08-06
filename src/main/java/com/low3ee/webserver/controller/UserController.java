package com.low3ee.webserver.controller;

import com.low3ee.webserver.dto.CreateUserRequest;
import com.low3ee.webserver.dto.UserResponse;
import com.low3ee.webserver.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest dto){
        return  ResponseEntity.ok(userService.createUser(dto));
    }
    @GetMapping
    public List<UserResponse> getAll(){
        return ResponseEntity.ok(userService.getAllUsers()).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update (@PathVariable String id, @RequestBody CreateUserRequest dto){
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
