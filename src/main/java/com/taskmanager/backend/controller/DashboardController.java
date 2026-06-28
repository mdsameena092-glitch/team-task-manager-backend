package com.taskmanager.backend.controller;

import com.taskmanager.backend.entity.Task;
import com.taskmanager.backend.repository.ProjectRepository;
import com.taskmanager.backend.repository.TaskRepository;
import com.taskmanager.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DashboardController {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalProjects", projectRepository.count());
        stats.put("totalUsers", userRepository.count());
        stats.put("totalTasks", taskRepository.count());
        stats.put("todoTasks", taskRepository.countByStatus(Task.Status.TODO));
        stats.put("inProgressTasks", taskRepository.countByStatus(Task.Status.IN_PROGRESS));
        stats.put("doneTasks", taskRepository.countByStatus(Task.Status.DONE));
        return ResponseEntity.ok(stats);
    }
}