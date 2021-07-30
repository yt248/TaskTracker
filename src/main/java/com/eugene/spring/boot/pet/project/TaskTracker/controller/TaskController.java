package com.eugene.spring.boot.pet.project.TaskTracker.controller;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.Task;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.ProjectRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/createTaskToProject/{projectId}")
    public String addTaskToProject(@PathVariable Long projectId, Model model) {

        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("projectId", projectId);
        return "task/add_task_page";
    }

    @PostMapping("/add/{projectId}")
    public String saveTaskToProject(@PathVariable Long projectId,
                                    @ModelAttribute Task task) {
        Project project = projectRepo.getById(projectId);
        task.setProject(project);
        project.getTaskList().add(task);
        // new ArrayList(project.getTaskList())
        // list.add(task)
        // project.setTaskList(list)
        projectRepo.save(project);
        return "redirect:/project/info/" + projectId;
    }


    @GetMapping("/editTaskStatus/{taskId}")
    public String editTaskStatus(@PathVariable Long taskId, Model model) {
        Task task = taskRepo.getById(taskId);
        model.addAttribute("task", task);
        return "task/edit_task_status_page";
    }

    @PostMapping("/update/{taskId}")
    public String updateTaskStatus(@ModelAttribute("task") Task updateTask, @PathVariable Long taskId) {
        Task task = taskRepo.getById(taskId);
        Project project = task.getProject();
        task.setName(updateTask.getName());
        task.setDescription(updateTask.getDescription());
        task.setTaskStatus(updateTask.getTaskStatus());
        task.setProject(project);
        taskRepo.save(task);
        return "redirect:/project/info/" + task.getProject().getId();
    }

    @GetMapping("/showDetails/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Task task = taskRepo.getById(id);
        model.addAttribute("task", task);
        return "task/details_task_page";
    }
}
