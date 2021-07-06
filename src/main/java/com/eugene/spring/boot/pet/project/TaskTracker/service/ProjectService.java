package com.eugene.spring.boot.pet.project.TaskTracker.service;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }


}
