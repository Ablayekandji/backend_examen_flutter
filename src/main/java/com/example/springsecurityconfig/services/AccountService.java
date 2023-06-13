package com.example.springsecurityconfig.services;

import com.example.springsecurityconfig.entities.AppRole;
import com.example.springsecurityconfig.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    public void addRoleToUser(String username, String roleName);
    Optional<AppUser> loadUserByUsername(String username);

    List<AppUser> listUsers();
}
