package com.cybertek.controller;

import com.cybertek.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Project Creation
    @GetMapping("/project-create")
    public String projectCreate() {
        return "/admin/project-create";
    }

    // User Creation
    @GetMapping({"/user-create", "/user-add", "/user-initialize"})
    public String userCreate(Model model) {

        model.addAttribute("user", new UserDTO());

        return "/admin/user-create";
    }

    @PostMapping("/user-create/save")
    public String saveUser() {
        return "/admin/user-create";
    }

}
