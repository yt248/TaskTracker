package com.eugene.spring.boot.pet.project.TaskTracker.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProjectDto {

    private Long id;

    private String name;

    private String description;

    private UserDto creator;

    private Set<UserDto> developers = new HashSet<>();

    private Set<TaskDto> taskList = new HashSet<>();

    public ProjectDto() {
    }

    public ProjectDto(String name, String description, UserDto creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
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

    public UserDto getCreator() {
        return creator;
    }

    public void setCreator(UserDto creator) {
        this.creator = creator;
    }

    public Set<UserDto> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<UserDto> developers) {
        this.developers = developers;
    }

    public Set<TaskDto> getTaskList() {
        return taskList;
    }

    public void setTaskList(Set<TaskDto> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
