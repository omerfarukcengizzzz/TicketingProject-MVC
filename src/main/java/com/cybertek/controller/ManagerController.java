package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {


    // ----------------- Task Creation -----------------
    @GetMapping("/task-create")
    public String createTask() {

        return "/manager/task_assign-create";
    }

}
