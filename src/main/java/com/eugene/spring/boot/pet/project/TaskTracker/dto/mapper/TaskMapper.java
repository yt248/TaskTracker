package com.eugene.spring.boot.pet.project.TaskTracker.dto.mapper;

import com.eugene.spring.boot.pet.project.TaskTracker.dto.TaskDto;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Task;

public class TaskMapper {


    public static TaskDto toDto(Task entity) {
        TaskDto dto = new TaskDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setTaskStatus(entity.getTaskStatus());

        dto.setProject(ProjectMapper.toDto(entity.getProject()));

        return dto;
    }


    public static Task toEntity(TaskDto dto) {
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTaskStatus(dto.getTaskStatus());

        entity.setProject(ProjectMapper.toEntity(dto.getProject()));

        return entity;
    }
}
