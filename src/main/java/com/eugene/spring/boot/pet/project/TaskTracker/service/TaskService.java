package com.eugene.spring.boot.pet.project.TaskTracker.service;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Task;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepo taskRepo;


    public List<Task> getAllTask(){
        return taskRepo.findAll();
    }

}
