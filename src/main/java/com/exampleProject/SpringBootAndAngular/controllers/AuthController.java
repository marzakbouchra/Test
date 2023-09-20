package com.exampleProject.SpringBootAndAngular.controllers;

import com.exampleProject.SpringBootAndAngular.security.AuthRequest;
import com.exampleProject.SpringBootAndAngular.service.UDService;
import com.exampleProject.SpringBootAndAngular.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UDService userDetailsService;

//add commentaire
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody AuthRequest authRequest) {
        String login = authRequest.getLogin();
        String password = authRequest.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        return ResponseEntity.ok().body(Map.of("token", jwtUtil.generateToken(userDetails), "user", userDetails));
    }
}
