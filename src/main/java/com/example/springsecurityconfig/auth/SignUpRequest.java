package com.example.springsecurityconfig.auth;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class SignUpRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String [] Roles;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
