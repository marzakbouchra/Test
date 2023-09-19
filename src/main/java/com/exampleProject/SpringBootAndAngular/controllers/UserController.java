package com.exampleProject.SpringBootAndAngular.controllers;

import com.exampleProject.SpringBootAndAngular.models.Role;
import com.exampleProject.SpringBootAndAngular.models.Utilisateur;
import com.exampleProject.SpringBootAndAngular.service.RoleService;
import com.exampleProject.SpringBootAndAngular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Utilisateur>> getUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        Utilisateur utilisateur1 = userService.save(utilisateur);
        return new ResponseEntity<>("utilisateur est bien enregistré !"+ utilisateur1.getName(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        Role role1 = roleService.save(role);
        return new ResponseEntity<>("Role est bien enregistré !"+role1.getName(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/role/addroletouser", method = RequestMethod.POST)
    public ResponseEntity<Object> saveRoleToUser(@RequestBody String username, @RequestBody String roleName) {
        return new ResponseEntity<>(userService.addRoleToUser(username, roleName), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public Utilisateur login(@RequestBody Utilisateur participant){
        return userService.login(participant);
    }
}
