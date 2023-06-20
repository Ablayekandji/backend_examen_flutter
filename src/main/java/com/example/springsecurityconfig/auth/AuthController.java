package com.example.springsecurityconfig.auth;


import com.example.springsecurityconfig.config.JwtService;
import com.example.springsecurityconfig.entities.AppRole;
import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.repos.AppRoleRepository;
import com.example.springsecurityconfig.repos.AppUserRepository;
import com.example.springsecurityconfig.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateJwtToken(authentication);
        UserDetails user = (UserDetails) authentication.getPrincipal();
        List<String> roles = user.getAuthorities().stream()
                .map(auth -> auth.getAuthority()).collect(Collectors.toList());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setRoles(roles);
        authResponse.setEmail(user.getUsername());
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody SignUpRequest signUpRequest){
        if(appUserRepository.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity.badRequest().body("Cet email est déjà utilisé");
        }
        AppUser appUser = new AppUser();
        Set<AppRole> roles = new HashSet<>();
        appUser.setEmail(signUpRequest.getEmail());
        appUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        String [] roleArr = signUpRequest.getRoles();
        if (roleArr == null){
            AppRole roleUser = appRoleRepository.findByRoleName("USER");
            roles.add(roleUser);
        }
        appUser.setAppRoles(roles);
        appUserRepository.save(appUser);
        return ResponseEntity.ok("Utilisateur enregistré avec success");
    }
}
