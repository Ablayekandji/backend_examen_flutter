package com.example.springsecurityconfig.repos;

import com.example.springsecurityconfig.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleName(String appRole);
}
