package com.example.springsecurityconfig.services;

import com.example.springsecurityconfig.entities.AppRole;
import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.repos.AppRoleRepository;
import com.example.springsecurityconfig.repos.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    AppUserRepository appUserRepository;
    AppRoleRepository appRoleRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Optional<AppUser> appUser = appUserRepository.findByEmail(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.get().getAppRoles().add(appRole);
    }

    @Override
    public Optional<AppUser> loadUserByUsername(String username) {
        return appUserRepository.findByEmail(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
