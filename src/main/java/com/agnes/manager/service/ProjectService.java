package com.agnes.manager.service;

import com.agnes.manager.dto.ProjectDTO;
import com.agnes.manager.model.Project;
import com.agnes.manager.model.StatusProject;
import com.agnes.manager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<ProjectDTO> getProjecDTOByStatus(String status) {
        StatusProject statusEnum = StatusProject.valueOf(status.toUpperCase());
        return projectRepository.findProjectDTOByStatus(statusEnum);
    }
}
