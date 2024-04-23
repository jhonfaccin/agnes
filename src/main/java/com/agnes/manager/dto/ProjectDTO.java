package com.agnes.manager.dto;

import com.agnes.manager.model.StatusProject;

public class ProjectDTO {
    private final Long customerId;
    private final Long id;
    private String name;
    private String status;
    private String customerName;

    public ProjectDTO(Long id,String name, StatusProject status, String customerName, Long customerId) {
        this.id = id;
        this.name = name;
        this.status = status.toString();
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
