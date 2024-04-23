package com.agnes.manager.repository;

import com.agnes.manager.dto.ProjectDTO;
import com.agnes.manager.model.Project;
import com.agnes.manager.model.StatusProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT new com.agnes.manager.dto.ProjectDTO(p.id, p.name, p.status, p.customer.name,p.customer.id) FROM project p WHERE p.status = :status")
    List<ProjectDTO> findProjectDTOByStatus(@Param("status") StatusProject status);
}