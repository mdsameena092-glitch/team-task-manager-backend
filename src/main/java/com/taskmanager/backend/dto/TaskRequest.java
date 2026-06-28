package com.taskmanager.backend.dto;

import lombok.Data;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private String status;
    private String dueDate;
    private Long projectId;
    private Long assignedToId;
}