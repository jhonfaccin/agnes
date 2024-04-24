package com.agnes.manager.presentation;

import java.time.LocalDate;

public record ActivityPresentation(Long id,
                                   String name,
                                   Long projectId,
                                   LocalDate startDate,
                                   LocalDate endDate) {
}
