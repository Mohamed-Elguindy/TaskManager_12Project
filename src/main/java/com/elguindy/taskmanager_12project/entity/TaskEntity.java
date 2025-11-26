package com.elguindy.taskmanager_12project.entity;

import com.elguindy.taskmanager_12project.utill.Priority;
import com.elguindy.taskmanager_12project.utill.Status;
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
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String title;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime dueDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status ;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

}
