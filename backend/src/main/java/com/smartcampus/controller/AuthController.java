package com.smartcampus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String studentId = body.get("studentId");
        String password = body.get("password");

        if ("IT23328020".equals(studentId) && "password".equals(password)) {
            return ResponseEntity.ok(Map.of(
                    "token", "dummy-jwt-token",
                    "userId", "user-001",
                    "email", "student@example.com",
                    "name", "Student User",
                    "role", "STUDENT",
                    "studentId", studentId,
                    "needsProfileSetup", false
            ));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid studentId or password"));
    }

    @PostMapping("/google")
    public ResponseEntity<Map<String, Object>> googleLogin(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        if (token == null || token.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Google token missing"));
        }

        return ResponseEntity.ok(Map.of(
                "token", "google-dummy-token",
                "userId", "google-user-001",
                "email", "googleuser@example.com",
                "name", "Google User",
                "role", "STUDENT",
                "studentId", "IT00000000",
                "needsProfileSetup", true
        ));
    }
}
