package com.elguindy.taskmanager_12project.repository;

import com.elguindy.taskmanager_12project.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
}
