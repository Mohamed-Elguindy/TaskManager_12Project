package com.elguindy.taskmanager_12project.service;

import com.elguindy.taskmanager_12project.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elguindy.taskmanager_12project.repository.TaskRepository;
import com.elguindy.taskmanager_12project.dto.TaskDTO;
import com.elguindy.taskmanager_12project.dto.TaskResponseDTO;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public TaskResponseDTO  createTask(TaskDTO taskDTO){
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setPriority(taskDTO.getPriority());
        taskEntity.setStatus(taskDTO.getStatus());
        taskEntity.setdueDate(taskDTO.getdueDate());
        TaskEntity savedEntity= taskRepository.save(taskEntity);
        return new TaskResponseDTO(savedEntity);
    }
    public TaskResponseDTO updateTask(Long id, TaskDTO taskDTO) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setPriority(taskDTO.getPriority());
        taskEntity.setStatus(taskDTO.getStatus());
        taskEntity.setdueDate(taskDTO.getdueDate());
        TaskEntity updatedEntity = taskRepository.save(taskEntity);
        return new TaskResponseDTO(updatedEntity);
    }
    public TaskResponseDTO deleteTask(long id){
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(taskEntity);
        return new TaskResponseDTO(taskEntity);
    }
    public List<TaskResponseDTO> getAllTasks(){
        List<TaskEntity> tasks= taskRepository.findAll();
        List<TaskResponseDTO> responseList = new ArrayList<>();
        for (TaskEntity task : tasks) {
            responseList.add(new TaskResponseDTO(task));
        }
        return responseList;
    }
}
