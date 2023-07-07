package com.example.springsecurityconfig.pointage;

import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.entities.Pointage;
import com.example.springsecurityconfig.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PointageService {

    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private PointageRepository pointageRepository;

    public boolean addPointage(String email){
        System.out.println("sur pointage");
        if (!this.getUsername().equals(email)) {
            System.out.println("sur return false");
            System.out.println("this.getUsername() "+this.getUsername());

            return false;
        }
        AppUser user = userRepository.findByEmail(email).orElseThrow();
        if (user!=null){
            Pointage pointage = Pointage.builder()
                    .heure(LocalDateTime.now())
                    .validate(true)
                    .user(user)
                    .build();
            pointageRepository.save(pointage);
            return true;
        }
        return false;
    }

    public List<Pointage> listPointage(){
        AppUser user = userRepository.findByEmail(this.getUsername()).orElseThrow();
        return pointageRepository.findPointagesByUser(user);
    }


        private  String getUsername() {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof AppUser) {
                return ((AppUser) principal).getEmail();
            } else {
                return principal.toString();
            }
        }

}
