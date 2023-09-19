package com.exampleProject.SpringBootAndAngular.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUtilisateur;
    private String name;
    private String login;
    private String password;
    private String email;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id")
    private Role role;

    public Utilisateur() {

    }

    public Utilisateur(Long idUtilisateur, String name, String login, String password, String email, Role role) {
        this.idUtilisateur = idUtilisateur;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
