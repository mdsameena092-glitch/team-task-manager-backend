package com.taskmanager.backend.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    private String name;
    private String description;
}