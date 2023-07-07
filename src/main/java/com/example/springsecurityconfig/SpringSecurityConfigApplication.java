package com.example.springsecurityconfig;

import com.example.springsecurityconfig.entities.AppRole;
import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class SpringSecurityConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityConfigApplication.class, args);
    }


}
