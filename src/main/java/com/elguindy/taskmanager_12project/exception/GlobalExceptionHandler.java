package com.elguindy.taskmanager_12project.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFound(TaskNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.errorMessage);
        return "error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {

        String errorMessage = "Invalid Input";

        model.addAttribute("errorMessage", errorMessage);

        return "error";
    }

}
