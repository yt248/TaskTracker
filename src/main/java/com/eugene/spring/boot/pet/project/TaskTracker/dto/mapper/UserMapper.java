package com.eugene.spring.boot.pet.project.TaskTracker.dto.mapper;

import com.eugene.spring.boot.pet.project.TaskTracker.dto.ProjectDto;
import com.eugene.spring.boot.pet.project.TaskTracker.dto.RoleDto;
import com.eugene.spring.boot.pet.project.TaskTracker.dto.UserDto;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;

import java.util.Set;

public class UserMapper {

    public static UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setGender(entity.getGender());
        dto.setVerificationCode(entity.getVerificationCode());
        dto.setEnabled(entity.isEnabled());
        dto.setBirthday(entity.getBirthday());

        Set<RoleDto> rolesDto = dto.getRoles();
        for (Role role : entity.getRoles()) {
            rolesDto.add(RoleMapper.toDto(role));
        }

        Set<ProjectDto> creatingProjectsDto = dto.getCreatingProjects();
        for (Project project : entity.getCreatingProjects()) {
            creatingProjectsDto.add(ProjectMapper.toDto(project));
        }

        Set<ProjectDto> listOfDeveloperProjectsDto = dto.getListOfDeveloperProjects();
        for (Project project : entity.getListOfDeveloperProjects()) {
            listOfDeveloperProjectsDto.add(ProjectMapper.toDto(project));
        }

        return dto;
    }

    public static User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
        entity.setVerificationCode(dto.getVerificationCode());
        entity.setEnabled(dto.isEnabled());
        entity.setBirthday(dto.getBirthday());

        Set<Role> rolesEntity = entity.getRoles();
        for (RoleDto roleDto : dto.getRoles()) {
            rolesEntity.add(RoleMapper.toEntity(roleDto));
        }

        Set<Project> creatingProjectsEntity = entity.getCreatingProjects();
        for (ProjectDto projectDto : dto.getCreatingProjects()) {
            creatingProjectsEntity.add(ProjectMapper.toEntity(projectDto));
        }

        Set<Project> listOfDeveloperProjectsEntity = entity.getListOfDeveloperProjects();
        for (ProjectDto projectDto : dto.getListOfDeveloperProjects()) {
            listOfDeveloperProjectsEntity.add(ProjectMapper.toEntity(projectDto));
        }

        return entity;
    }
}
