package com.exampleProject.SpringBootAndAngular.service;

import com.exampleProject.SpringBootAndAngular.models.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Utilisateur save(Utilisateur utilisateur);
    Optional<Utilisateur> addRoleToUser(String login, String nameRole);
    Optional<Utilisateur> getUser(String login);
    List<Utilisateur> getAll();
    Utilisateur getById(Long id);
    Utilisateur login(Utilisateur utilisateur);
}
