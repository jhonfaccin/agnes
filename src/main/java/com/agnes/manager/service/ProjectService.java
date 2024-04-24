package com.agnes.manager.service;

import com.agnes.manager.model.Project;
import com.agnes.manager.model.StatusProject;
import com.agnes.manager.presentation.ActivityPresentation;
import com.agnes.manager.presentation.ProjectDTO;
import com.agnes.manager.presentation.ProjectPresentation;
import com.agnes.manager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectPresentation> getAllProjects() {
        return projectRepository.findAll().stream().map(project ->
                        new ProjectPresentation(project.getId(),
                                project.getName(),
                                project.getStatus(),
                                project.getCustomer().getName(),
                                project.getCustomer().getId()))
                .collect(Collectors.toList());
    }

    public List<ProjectPresentation> getAllProjectsByStatus(String status) {
        StatusProject statusEnum = StatusProject.valueOf(status.toUpperCase());
        List<Project> projects = projectRepository.findAllByStatus(statusEnum);
        return projects.stream()
                .map(project -> new ProjectPresentation(
                        project.getId(),
                        project.getName(),
                        project.getStatus(),
                        project.getCustomer().getName(),
                        project.getCustomer().getId()))
                .collect(Collectors.toList());
    }

    public ProjectDTO getProjectById(Long id) {
        return projectRepository.findById(id).stream()
                .map(project -> new ProjectDTO(
                        project.getId(),
                        project.getName(),
                        project.getStatus(),
                        project.getCustomer().getName(),
                        project.getCustomer().getId(),
                        project.getActivities().stream()
                                .map(activity -> new ActivityPresentation(
                                        activity.getId(),
                                        activity.getName(),
                                        activity.getProject().getId(),
                                        activity.getStartDate(),
                                        activity.getEndDate()
                                ))
                                .collect(Collectors.toList())
                ))
                .findFirst().orElseThrow(() -> new FindException("Project not found"));
    }

}
