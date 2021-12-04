package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {


    // ----------------- Task Creation -----------------
    @GetMapping("/task-create")
    public String createTask(Model model) {

        model.addAttribute("tasks", new TaskDTO());

        return "/manager/task_assign-create";
    }

}
