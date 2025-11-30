package com.elguindy.taskmanager_12project.exception;

public class TaskNotFoundException extends RuntimeException {
    String errorMessage;
    public TaskNotFoundException(Long id) {
        errorMessage = "Task of id : " + id + " not found";
    }
}


