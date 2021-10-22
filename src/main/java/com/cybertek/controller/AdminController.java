package com.cybertek.controller;

import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // DI
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    // User Creation
    @GetMapping({"/user-create", "/user-add", "/user-initialize"})
    public String userCreate(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("userList", userService.findAll());

        return "/admin/user-create";
    }

    @PostMapping("/user-create/save")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO) {

        userService.save(userDTO);

        return "/admin/user-create";
    }





    // Project Creation
    @GetMapping("/project-create")
    public String projectCreate() {
        return "/admin/project-create";
    }

}
