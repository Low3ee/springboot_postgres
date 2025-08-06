package com.low3ee.webserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String fname;
    private String lname;
    private String email;
}
