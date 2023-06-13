package com.example.springsecurityconfig.test;

import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.repos.AppUserRepository;
import com.example.springsecurityconfig.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class TestController {

    private final AccountService accountService;
    @GetMapping("/list")
    public ResponseEntity<List<AppUser>> allUsers(){
        List<AppUser> list = accountService.listUsers();
        return ResponseEntity.ok(list);
    }
}
