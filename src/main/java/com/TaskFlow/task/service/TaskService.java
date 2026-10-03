package com.TaskFlow.task.service;

import com.TaskFlow.task.entities.Category;
import com.TaskFlow.task.entities.Task;
import com.TaskFlow.task.repository.CategoryRepository;
import com.TaskFlow.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public Task createTask(Task task, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with Id " + categoryId));

        task.setCategory(category);

        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> readTask(Integer id) {
        return taskRepository.findById(id);
    }

    public Task  updateTask(Integer taskId, Task taskDetails, Integer categoryId) {

        if (taskRepository.findById(taskId).isPresent()) {
            taskDetails.setTaskId(taskId);
            taskRepository.save(taskDetails);
        }

        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with Id " + taskId));

        existingTask.setName(taskDetails.getName());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setInitialDeadline(taskDetails.getInitialDeadline());
        existingTask.setDeadline(taskDetails.getDeadline());
        existingTask.setDeadline(taskDetails.getDeadline());

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with Id " + categoryId));

        existingTask.setCategory(category);

        return taskRepository.save(existingTask);
    }

    public List<Task> listar() {
        return taskRepository.findAll();
    }
}
