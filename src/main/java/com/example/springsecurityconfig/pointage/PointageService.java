package com.example.springsecurityconfig.pointage;

import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.entities.Pointage;
import com.example.springsecurityconfig.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PointageService {

    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private PointageRepository pointageRepository;

    public boolean addPointage(String email){
        System.out.println("sur pointage");
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
}
