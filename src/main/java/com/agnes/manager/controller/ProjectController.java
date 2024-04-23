package com.agnes.manager.controller;

import com.agnes.manager.model.Project;
import com.agnes.manager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
    @GetMapping("/{status}")
    public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status) {
        List<Project> projects = projectService.getProjecByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
}