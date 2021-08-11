package com.eugene.spring.boot.pet.project.TaskTracker.dto.mapper;

import com.eugene.spring.boot.pet.project.TaskTracker.dto.ProjectDto;
import com.eugene.spring.boot.pet.project.TaskTracker.dto.TaskDto;
import com.eugene.spring.boot.pet.project.TaskTracker.dto.UserDto;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Task;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;

import java.util.Set;

public class ProjectMapper {

    public static ProjectDto toDto(Project entity) {
        ProjectDto dto = new ProjectDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreator(UserMapper.toDto(entity.getCreator()));

        Set<UserDto> developersDto = dto.getDevelopers();
//        Set<UserDto> developersDto = (Set<UserDto>) entity.getDevelopers().stream().map(UserMapper::toDto).collect(Collectors.toList());
        for (User user : entity.getDevelopers()) {
            developersDto.add(UserMapper.toDto(user));
        }


        Set<TaskDto> taskListDto = dto.getTaskList();
        for (Task task : entity.getTaskList()) {
            taskListDto.add(TaskMapper.toDto(task));
        }

        return dto;
    }

    public static Project toEntity(ProjectDto dto) {
        Project entity = new Project();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCreator(UserMapper.toEntity(dto.getCreator()));

        Set<User> developersEntity = entity.getDevelopers();
        for (UserDto userDto : dto.getDevelopers()) {
            developersEntity.add(UserMapper.toEntity(userDto));
        }

        Set<Task> taskListEntity = entity.getTaskList();
        for (TaskDto taskDto : dto.getTaskList()) {
            taskListEntity.add(TaskMapper.toEntity(taskDto));
        }

        return entity;
    }

}
