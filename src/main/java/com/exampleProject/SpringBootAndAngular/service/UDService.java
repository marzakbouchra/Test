package com.exampleProject.SpringBootAndAngular.service;

import com.exampleProject.SpringBootAndAngular.models.Utilisateur;
import com.exampleProject.SpringBootAndAngular.repositories.UserRepository;
import com.exampleProject.SpringBootAndAngular.security.UserSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UDService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserSecurity(utilisateur);
    }
}
