package com.elguindy.taskmanager_12project.dto;
import com.elguindy.taskmanager_12project.utill.Priority;
import com.elguindy.taskmanager_12project.utill.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TaskDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Status status;
    @NotNull
    private Priority priority;
    @NotNull
    private LocalDateTime dueDate;

}
