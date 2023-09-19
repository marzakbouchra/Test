package com.exampleProject.SpringBootAndAngular.service;

import com.exampleProject.SpringBootAndAngular.models.Role;
import com.exampleProject.SpringBootAndAngular.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
