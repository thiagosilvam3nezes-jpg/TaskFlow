package com.TaskFlow.task.controller;

import com.TaskFlow.task.entities.Task;
import com.TaskFlow.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void createTask(@RequestBody Task newTask, Integer categoryId) {
        taskService.createTask(newTask, categoryId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Integer id,
            @RequestBody Task newTask,
            @RequestParam Integer categoryId) {
        Task updated = taskService.updateTask(id, newTask, categoryId);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public void readTask(@RequestParam Integer id) {
        taskService.readTask(id);
    }

    @GetMapping
    public List<Task> listarTarefas(@RequestParam Integer id) {
        return taskService.listar();
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Integer id) {
        taskService.deleteTask(id);
    }
}
