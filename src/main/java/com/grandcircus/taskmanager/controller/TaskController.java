package com.grandcircus.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grandcircus.taskmanager.model.Task;
import com.grandcircus.taskmanager.repository.TaskRepository;
import com.grandcircus.taskmanager.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService; // Autowire TaskService

    @GetMapping
    public String listTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "task/list";
    }    

    @GetMapping("/tasks")
    public String getTasks(Model model,
        @RequestParam(name = "search", required = false) String search,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter) {
        
        // Logic to retrieve tasks based on search, sort, and filter parameters
        List<Task> tasks = taskService.getTasks(search, sort, filter);

        // Add tasks to the model
        model.addAttribute("tasks", tasks);
        model.addAttribute("search", search);
        model.addAttribute("sort", sort);
        model.addAttribute("filter", filter);

        return "tasks";
    }


    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/complete/{taskId}")
    public String completeTask(@PathVariable Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        task.setCompleted(true);
        taskRepository.save(task);
        return "redirect:/tasks";
    }
    

    @PostMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskRepository.deleteById(taskId);
        return "redirect:/tasks";
    }
}
