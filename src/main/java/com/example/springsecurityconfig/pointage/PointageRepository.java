package com.example.springsecurityconfig.pointage;

import com.example.springsecurityconfig.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointageRepository extends JpaRepository<Pointage, Long> {
}
