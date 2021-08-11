package com.eugene.spring.boot.pet.project.TaskTracker.service;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    Role readRoleById(Integer id);

    void updateRole(Integer id, Role newRole);

    void deleteRole(Integer id);

    List<Role> getAllRoles();


}
