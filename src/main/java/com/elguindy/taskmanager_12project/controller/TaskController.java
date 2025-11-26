package com.elguindy.taskmanager_12project.controller;

import com.elguindy.taskmanager_12project.dto.TaskDTO;
import com.elguindy.taskmanager_12project.dto.TaskResponseDTO;
import com.elguindy.taskmanager_12project.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;



    @PostMapping("tasks/{id}")
    public String updateTask(@PathVariable Long id,
                             @Valid @ModelAttribute TaskDTO taskDTO) {

        taskService.updateTask(id, taskDTO);
        return "redirect:/";
    }

    @GetMapping({"/tasks" , "/"})
    public ModelAndView getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("tasks", tasks);
        mv.addObject("task", new TaskDTO());

        return mv;
    }


    @PostMapping("/tasks")
    public String createTask(@ModelAttribute("task") @Valid TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        return "redirect:/";
    }

    @GetMapping("tasks/delete/{id}")
    public ModelAndView deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ModelAndView("redirect:/");
    }

}
