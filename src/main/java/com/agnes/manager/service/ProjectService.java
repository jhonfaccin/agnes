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
    @Autowired ActivityService activityService;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<ProjectDTO> getProjecDTOByStatus(String status) {
        StatusProject statusEnum = StatusProject.valueOf(status.toUpperCase());
        return projectRepository.findProjectDTOByStatus(statusEnum);
    }

    public ProjectDTO getProjectDTOById(Long id) throws Exception {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            throw new Exception("Project not found");
        }
        return convertToDTO(project);
    }

    private ProjectDTO convertToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setCustomerId(project.getCustomer().getId());
        dto.setStatus(project.getStatus().getValue());
        dto.setActivities(activityService.convertToDTOList(project.getActivities()));
        return dto;
    }
}
