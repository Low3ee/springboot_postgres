package com.low3ee.webserver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email is invalid.")
    private String email;

    @NotBlank(message = "Password cannot be empty.")
    private String password;
}
