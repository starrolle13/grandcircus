package com.grandcircus.taskmanager.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grandcircus.taskmanager.model.Task;
import com.grandcircus.taskmanager.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks(String search, String sort, String filter) {
        // Retrieve all tasks
        List<Task> tasks = taskRepository.findAll();

        // Apply search filter
        if (search != null && !search.isEmpty()) {
            tasks = tasks.stream()
                    .filter(task -> task.getDescription().contains(search))
                    .collect(Collectors.toList());
        }

        // Apply sorting
        if (sort != null && !sort.isEmpty()) {
            Comparator<Task> comparator = Comparator.comparing(Task::getDueDate);

            if (sort.equals("Descending")) {
                comparator = comparator.reversed();
            }

            tasks.sort(comparator);
        }

        // Apply completion status filter
        if (filter != null && !filter.isEmpty()) {
            boolean completedFilter = filter.equals("Completed");

            tasks = tasks.stream()
                    .filter(task -> task.isCompleted() == completedFilter)
                    .collect(Collectors.toList());
        }

        return tasks;
    }
}
