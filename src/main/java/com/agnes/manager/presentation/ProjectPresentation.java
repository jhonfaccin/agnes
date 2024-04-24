package com.agnes.manager.presentation;

import com.agnes.manager.model.StatusProject;

public record ProjectPresentation(Long id,
                                  String name,
                                  StatusProject statusProject,
                                  String customerName,
                                  Long customerId) {

}
