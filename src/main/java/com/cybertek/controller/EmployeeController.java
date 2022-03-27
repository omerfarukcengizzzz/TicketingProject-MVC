package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //DI
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    TaskService taskService;

    // ----------------- Task Status -----------------
    @GetMapping("/pending-tasks")
    public String taskStatus(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("employeeList", userService.findEmployees());
        model.addAttribute("taskList", taskService.findAll());
        model.addAttribute("statusList", Status.values());

        return "/employee/pending-tasks";
    }

}
