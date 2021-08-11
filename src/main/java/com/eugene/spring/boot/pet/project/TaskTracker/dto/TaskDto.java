package com.eugene.spring.boot.pet.project.TaskTracker.dto;


import com.eugene.spring.boot.pet.project.TaskTracker.entity.TaskStatus;

import java.util.Objects;

public class TaskDto {


    private Long id;

    private String name;

    private String description;

    private TaskStatus taskStatus;

    private ProjectDto project;


    public TaskDto() {
    }

    public TaskDto(Long id, String name, String description, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(id, taskDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
