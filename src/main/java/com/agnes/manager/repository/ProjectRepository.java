package com.agnes.manager.repository;

import com.agnes.manager.model.Project;
import com.agnes.manager.model.StatusProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByStatus(StatusProject status);

//    @Query("SELECT new com.agnes.manager.dto.ProjectDTO(p.id, p.name, p.status, p.customer.name,p.customer.id) FROM project p WHERE p.status = :status")
//    List<ProjectDTO> findProjectDTOByStatus(@Param("status") StatusProject status);

//    @Query("SELECT p FROM Project p WHERE p.status = :status")
//    List<ProjectPresentation> findAllProjectsByStatus(@Param("status") StatusProject status);


}