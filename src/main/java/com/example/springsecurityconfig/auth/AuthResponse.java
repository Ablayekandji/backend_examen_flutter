package com.example.springsecurityconfig.auth;

import lombok.Data;

import java.util.List;

@Data
public class AuthResponse {
    private String token;
    private List<String> roles;
}
