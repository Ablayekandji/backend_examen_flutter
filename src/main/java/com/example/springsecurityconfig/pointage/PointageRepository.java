package com.example.springsecurityconfig.pointage;

import com.example.springsecurityconfig.entities.AppUser;
import com.example.springsecurityconfig.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointageRepository extends JpaRepository<Pointage, Long> {

    List<Pointage> findPointagesByUser(AppUser user);
}
