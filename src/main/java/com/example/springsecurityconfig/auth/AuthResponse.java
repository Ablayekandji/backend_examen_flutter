package com.example.springsecurityconfig.auth;

import lombok.Data;

import java.util.List;

@Data
public class AuthResponse {
    private String token;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
