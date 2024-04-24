package com.agnes.manager.presentation;

import com.agnes.manager.model.StatusProject;

import java.util.List;

public record ProjectDTO(Long id,
                         String name,
                         StatusProject status,
                         String customerName,
                         Long customerId,
                         List<ActivityPresentation> activities) {
}
