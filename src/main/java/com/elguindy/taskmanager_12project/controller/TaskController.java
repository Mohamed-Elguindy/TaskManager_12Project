package com.elguindy.taskmanager_12project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TaskController {

    @GetMapping("/")
    public String Home(){
        return "index";
    }
}
