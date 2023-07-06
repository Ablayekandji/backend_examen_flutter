package com.example.springsecurityconfig.pointage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pointage")
public class PointageController {

    @Autowired
    private PointageService pointageService;
    @PostMapping("")
    public ResponseEntity<Boolean> setOpened(@RequestParam("email") String email){
        return ResponseEntity.ok(pointageService.addPointage(email));
    }
}
