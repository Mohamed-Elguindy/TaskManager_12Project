package com.elguindy.taskmanager_12project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TaskEntity {
    @Id
    private Long id;

    private String title;

}
