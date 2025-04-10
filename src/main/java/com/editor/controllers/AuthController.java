package com.editor.controllers;

import com.editor.models.AuthRequest;
import com.editor.models.User;
import com.editor.services.JwtUtil;
import com.editor.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    // ✅ Add Constructor to Initialize Dependencies
    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                request.getUsername(), "", new ArrayList<>()
        );
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
}
