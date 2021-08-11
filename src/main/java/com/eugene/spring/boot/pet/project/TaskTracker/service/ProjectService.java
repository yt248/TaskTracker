package com.eugene.spring.boot.pet.project.TaskTracker.service;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;

import java.util.List;

public interface ProjectService {

    void creatProject(Project project);

    Project readProjectById(Long id);

    void updateProject(Long id, Project newProject);

    void delete(Long id);

    List<Project> getAllProjects();
}
