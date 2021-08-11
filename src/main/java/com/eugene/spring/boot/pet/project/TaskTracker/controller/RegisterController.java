package com.eugene.spring.boot.pet.project.TaskTracker.controller;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.Role;
import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.RoleRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.repository.UserRepo;
import com.eugene.spring.boot.pet.project.TaskTracker.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    @Autowired
    public RegisterController(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        List<Role> listRoles = roleRepo.findAll();
        listRoles.removeIf(role -> role.getName().startsWith("ADMIN"));
        model.addAttribute("listRoles", listRoles);
        return "register/register_form";
    }


    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("user") User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        //Шифрование пароля
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        userServiceImpl.register(user, getSiteURL(request));
        return "register/register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }


    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userServiceImpl.verify(code)) {
            return "register/verify_success";
        } else {
            return "register/verify_fail";
        }
    }


    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

}
