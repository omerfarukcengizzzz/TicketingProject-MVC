package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/project-create")
    public String projectCreate() {
        return "/admin/project-create";
    }

    @GetMapping({"/user-create", "/user-add", "/user-initialize"})
    public String userCreate() {
        return "/admin/user-create";
    }

    @PostMapping("/user-create/save")
    public String saveUser() {
        return "/admin/user-create";
    }
}
