package com.eugene.spring.boot.pet.project.TaskTracker.repository;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer > {
}
