package com.eugene.spring.boot.pet.project.TaskTracker.service.impl;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.RoleRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void createRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public Role readRoleById(Integer id) {
        return roleRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Role %d not found", id)));
    }

    @Override
    @Transactional
    public void updateRole(Integer id, Role newRole) {
        Role updateRole = readRoleById(id);
        updateRole.setName(newRole.getName());
        roleRepo.save(updateRole);
    }

    @Override
    @Transactional
    public void deleteRole(Integer id) {
        Role role = readRoleById(id);
        roleRepo.delete(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
