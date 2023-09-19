package com.exampleProject.SpringBootAndAngular.service;

import com.exampleProject.SpringBootAndAngular.models.Role;
import com.exampleProject.SpringBootAndAngular.models.Utilisateur;
import com.exampleProject.SpringBootAndAngular.repositories.RoleRepository;
import com.exampleProject.SpringBootAndAngular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public Optional<Utilisateur> addRoleToUser(String login, String nameRole) {
        Optional<Utilisateur> utilisateur = userRepository.findByLogin(login);
        Role role = roleRepository.findByName(nameRole);
        utilisateur.get().setRole(role);
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> getUser(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<Utilisateur> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Utilisateur getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Utilisateur login(Utilisateur utilisateur) {
        return userRepository.findByEmail(utilisateur.getEmail());
    }
}
