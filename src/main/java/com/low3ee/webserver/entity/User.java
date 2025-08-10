package com.low3ee.webserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 100)
    private String fname;

    @Column(nullable = false, length = 100)
    private String lname;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    @Column
    private boolean enabled;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
