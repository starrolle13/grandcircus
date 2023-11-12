package com.grandcircus.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;  // Import LocalDate from java.time
import java.util.List;
import com.grandcircus.taskmanager.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCompleted(boolean completed);

    List<Task> findByDescriptionContainingIgnoreCase(String keyword);

    List<Task> findByDueDateOrderByDueDateAsc(LocalDate dueDate);

    List<Task> findByOrderByDueDateAsc();

    // Additional query methods if needed
}
