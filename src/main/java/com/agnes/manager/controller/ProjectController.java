package com.agnes.manager.controller;

import com.agnes.manager.presentation.ProjectDTO;
import com.agnes.manager.presentation.ProjectPresentation;
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

    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectPresentation>> getAllProjects() {
        List<ProjectPresentation> projects = projectService.getAllProjects();
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @GetMapping("status/{status}")
    public ResponseEntity<List<ProjectPresentation>> getProjectsByStatus(@PathVariable String status) {
        List<ProjectPresentation> projects = projectService.getAllProjectsByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) throws Exception {
        ProjectDTO project = projectService.getProjectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }
}