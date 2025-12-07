package com.elguindy.taskmanager_12project.dto;

import com.elguindy.taskmanager_12project.entity.TaskEntity;
import com.elguindy.taskmanager_12project.utill.Priority;
import com.elguindy.taskmanager_12project.utill.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime dueDate;
    public TaskResponseDTO(TaskEntity taskEntity) {
        this.id = taskEntity.getId();
        this.title = taskEntity.getTitle();
        this.description = taskEntity.getDescription();
        this.priority = taskEntity.getPriority();
        this.status = taskEntity.getStatus();
        this.dueDate = taskEntity.getDueDate();
    }

}
