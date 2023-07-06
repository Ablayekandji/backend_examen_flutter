package com.example.springsecurityconfig.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pointage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime heure;
    private boolean validate;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private AppUser user;

}
