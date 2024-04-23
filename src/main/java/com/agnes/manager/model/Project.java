package com.agnes.manager.model;

import jakarta.persistence.*;

@Entity(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_id")
    private StatusProject status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }
}
