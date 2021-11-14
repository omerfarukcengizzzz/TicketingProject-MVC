package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
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


    // ----------------- User List - Update -----------------
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findByID(username));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("roleList", roleService.findAll());

        return "/admin/user-update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, Model model, @ModelAttribute("user") UserDTO user) {

        userService.update(user);

        return "redirect:/admin/user-create";
    }

    // ----------------- User List - Delete -----------------
    @GetMapping("/delete/{username}")
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

        return "redirect:/admin/project-create";
    }


}
