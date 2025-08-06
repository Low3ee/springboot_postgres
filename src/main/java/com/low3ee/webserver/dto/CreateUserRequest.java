package com.low3ee.webserver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank(message = "First name is required.")
    private String fname;

    @NotBlank(message = "Last name is required.")
    private String lname;

    @Email(message = "Invalid Email Format.")
    @NotBlank( message = "Email is required.")
    private String email;

    @Size(min = 6, message = "Password must be atleast 6 characters.")
    @NotBlank(message = "Password is required.")
    private String password;

}
