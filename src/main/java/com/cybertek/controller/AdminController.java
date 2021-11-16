package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // DI
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    ProjectService projectService;

    // ----------------- User Creation -----------------
    @GetMapping({"/user-create", "/user-add", "/user-initialize"})
    public String userCreate(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("userList", userService.findAll());

        return "/admin/user-create";
    }

    @PostMapping("/user-create/save")
    public String saveUser(@ModelAttribute("user") UserDTO user, Model model) {

        userService.save(user);

        /*
           // redirect: does exactly the same thing, it calls the userCreate method instead of calling the html page
           model.addAttribute("user", new UserDTO());
           model.addAttribute("roleList", roleService.findAll());
           model.addAttribute("userList", userService.findAll());
        */

        return "redirect:/admin/user-create";
    }


    // ----------------- User - Update -----------------
    @GetMapping("/user-update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findByID(username));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("roleList", roleService.findAll());

        return "/admin/user-update";
    }

    @PostMapping("/user-update/{username}")
    public String updateUser(@PathVariable("username") String username, Model model, @ModelAttribute("user") UserDTO user) {

        userService.update(user);

        return "redirect:/admin/user-create";
    }

    // ----------------- User - Delete -----------------
    @GetMapping("/user-delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {

        userService.deleteByID(username);

        return "redirect:/admin/user-create";
    }


    // ----------------- Project Creation -----------------
    @GetMapping("/project-create")
    public String projectCreate(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("managerList", userService.findAll());

        return "/admin/project-create";
    }

    @PostMapping("/project-create/save")
    public String projectUpdate(@ModelAttribute("project") ProjectDTO project) {

        projectService.save(project);
        project.setStatus(Status.OPEN);

        return "redirect:/admin/project-create";
    }

    // ----------------- Project - Delete -----------------
    @GetMapping("/project-delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {

        projectService.deleteByID(projectCode);

        return "redirect:/admin/project-create";
    }

    // ----------------- Project - Update -----------------
    @GetMapping("/project-update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model) {

        System.out.println(projectService.findByID(projectCode).getStatus());

        model.addAttribute("project", projectService.findByID(projectCode));
        model.addAttribute("managerList", userService.findAll());
        model.addAttribute("projectList", projectService.findAll());


        return "/admin/project-update";
    }

    @PostMapping("/project-update/{projectCode}")
    public String updateProject(@ModelAttribute("project") ProjectDTO project) {

        var status = project.getStatus();
        projectService.save(project);
        project.setStatus(status);

        return "redirect:/admin/project-create";
    }


}
