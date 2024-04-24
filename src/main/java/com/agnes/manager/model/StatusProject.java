package com.agnes.manager.model;

import java.lang.module.FindException;
import java.util.Arrays;

public enum StatusProject {
    PLANNING("PLANNING"),
    OPEN("OPEN"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED");

    private final String value;

    StatusProject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusProject fromName(final String valueParamter) {
        return Arrays.stream(StatusProject.values())
                .filter(statusProject -> statusProject.value.equals(valueParamter))
                .findFirst()
                .orElseThrow(() -> new FindException("Project not found " + valueParamter));
    }
}