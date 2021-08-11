package com.eugene.spring.boot.pet.project.TaskTracker.controller;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Project;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.ProjectRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.UserRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.service.CustomUserDetails;
import com.eugene.spring.boot.pet.project.TaskTracker.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/")
    public String allProject(Model model, Principal principal){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        CustomUserDetails principalCustom = (CustomUserDetails) authentication.getPrincipal();
        //        model.addAttribute("principalName", principal.getName());
        model.addAttribute("principalName", principalCustom.getFullName());


        List<Project> listOnlyOneUser = projectRepo.findProjectByCreator(principal.getName());
        model.addAttribute("projectList", listOnlyOneUser);

//        List<Project> listOnlyJobProject = projectRepo.findProjectByJobProject(principal.getName());
//        model.addAttribute("projectListJob", listOnlyJobProject);



        return "project/index";
    }

    @GetMapping("/info/{id}")
    public String getProjectById(@PathVariable Long id, Model model){
        Project byId = projectRepo.getById(id);
        model.addAttribute("projectInfo",byId);
        return "project/info_project_page";
    }

    @GetMapping("/create")
    public String creatProject(Model model){
        model.addAttribute("project", new Project());
        return "project/add_Project_Page";
    }

    @PostMapping("/add")
    public String addProject(Project project, Principal principal){
        User byEmail = userRepo.findByEmail(principal.getName());
        project.setCreator(byEmail);
        projectRepo.save(project);
        return "redirect:/project/";
    }



}
