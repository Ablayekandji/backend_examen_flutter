package com.example.springsecurityconfig.auth;

import lombok.Data;

import java.util.List;

@Data
public class AuthResponse {
    private String token;
    private String email;
    private List<String> roles;
}
