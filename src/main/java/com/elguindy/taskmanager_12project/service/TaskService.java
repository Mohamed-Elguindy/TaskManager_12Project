package com.elguindy.taskmanager_12project.service;

import com.elguindy.taskmanager_12project.exception.TaskNotFoundException;
import com.elguindy.taskmanager_12project.repository.TaskRepository;
import com.elguindy.taskmanager_12project.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elguindy.taskmanager_12project.dto.TaskDTO;
import com.elguindy.taskmanager_12project.dto.TaskResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public void  createTask(TaskDTO taskDTO){
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setPriority(taskDTO.getPriority());
        taskEntity.setStatus(taskDTO.getStatus());
        taskEntity.setDueDate(taskDTO.getDueDate());
        taskRepository.save(taskEntity);
    }
    public void updateTask(Long id, TaskDTO taskDTO) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        if (taskEntityOptional.isPresent()) {
            TaskEntity taskEntity = taskEntityOptional.get();
            taskEntity.setTitle(taskDTO.getTitle());
            taskEntity.setDescription(taskDTO.getDescription());
            taskEntity.setPriority(taskDTO.getPriority());
            taskEntity.setStatus(taskDTO.getStatus());
            taskEntity.setDueDate(taskDTO.getDueDate());
            taskRepository.save(taskEntity);
        }
        else{
            throw new TaskNotFoundException(id);
        }

    }
    public void deleteTask(long id){
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        if (taskEntityOptional.isPresent()) {
            taskRepository.delete(taskEntityOptional.get());
        }
        else{
            throw new TaskNotFoundException(id);
        }
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
