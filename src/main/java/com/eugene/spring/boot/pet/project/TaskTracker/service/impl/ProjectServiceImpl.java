package com.eugene.spring.boot.pet.project.TaskTracker.service.impl;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.ProjectRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public void creatProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public Project readProjectById(Long id) {
        return projectRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Project %d not found", id)));
    }

    @Override
    @Transactional
    public void updateProject(Long id, Project newProject) {
        Project updateProject = readProjectById(id);
        updateProject.setName(newProject.getName());



        projectRepo.save(updateProject);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Project project = readProjectById(id);
        projectRepo.delete(project);
    }

    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }



}
