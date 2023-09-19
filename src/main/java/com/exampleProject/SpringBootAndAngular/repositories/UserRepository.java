package com.exampleProject.SpringBootAndAngular.repositories;

import com.exampleProject.SpringBootAndAngular.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);
    Optional<Utilisateur> findByLogin(String login);
}
