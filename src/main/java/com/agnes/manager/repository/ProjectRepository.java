package com.agnes.manager.repository;

import com.agnes.manager.model.Project;
import com.agnes.manager.model.StatusProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStatus(StatusProject status);
}