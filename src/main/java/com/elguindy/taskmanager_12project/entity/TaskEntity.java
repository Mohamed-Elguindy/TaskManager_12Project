package com.elguindy.taskmanager_12project.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String title;
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    @UpdateTimestamp
    private LocalDateTime dueDate;
 //   private StatusEnum statusEnum ;
//private Priority priorityEnum;

}
