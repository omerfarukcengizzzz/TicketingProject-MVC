package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    // DI
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    // ----------------- Task Creation -----------------
    @GetMapping("/task-create")
    public String createTask(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("employeeList", userService.findEmployees());
        model.addAttribute("taskList", taskService.findAll());

        return "/manager/task_assign-create";
    }

    @PostMapping("/task-create/save")
    public String saveTask(@ModelAttribute("task") TaskDTO task) {

        task.setAssignedDate(LocalDate.now());
        task.setStatus(Status.OPEN);
        task.setId(UUID.randomUUID().getMostSignificantBits());
        taskService.save(task);

        return "redirect:/manager/task-create";
    }

    // ----------------- Task - Delete -----------------
    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {

        taskService.deleteByID(id);

        return "redirect:/manager/task-create";
    }

    // ----------------- Task - Update -----------------
    @GetMapping("/task-update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {

        model.addAttribute("task", taskService.findByID(id));
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("employeeList", userService.findEmployees());
        model.addAttribute("taskList", taskService.findAll());

        return "/manager/task_assign-update";
    }

    @PostMapping("/task-update/{id}")
    public String updateTask(@ModelAttribute("task") TaskDTO task) {

        taskService.update(task);

        return "redirect:/manager/task-create";
    }



}