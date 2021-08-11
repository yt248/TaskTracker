package com.eugene.spring.boot.pet.project.TaskTracker.dto.mapper;

import com.eugene.spring.boot.pet.project.TaskTracker.dto.RoleDto;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;

public class RoleMapper {

    public static RoleDto toDto(Role entity) {
        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }


    public static Role toEntity(RoleDto dto) {
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}
