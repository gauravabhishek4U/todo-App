package com.app.todoApp.services;

import com.app.todoApp.model.Task;
import com.app.todoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // create a new task
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    // delete task by Id
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // toggle task by Id
    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task Id!!!"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
