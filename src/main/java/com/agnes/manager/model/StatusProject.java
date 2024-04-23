package com.agnes.manager.model;

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
    public static StatusProject fromName(String value) {
        for (StatusProject status : StatusProject.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}