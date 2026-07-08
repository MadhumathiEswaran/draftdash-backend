package com.example.draftdash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class documentEntity {
    @Id
        @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Workspace cannot be empty")
    private String workspace;

    @NotBlank(message = "Current status cannot be empty")
    private String currentstatus;

    @NotBlank(message = "Created by cannot be empty")
    private String createdby;
    private String password;
    public documentEntity() {
    }
    public documentEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Title cannot be empty") @Size(min = 3, max = 50, message = "Title must have only 3-50 characters") String title,
            @NotBlank(message = "Workspace cannot be empty") @Size(min = 3, max = 30, message = "Workspace must have only 3-30 characters") String workspace,
            @NotBlank(message = "Current status cannot be empty") @Size(min = 3, max = 20, message = "Current status must have only 3-20 characters") String currentstatus,
            @NotBlank(message = "Created by cannot be empty") @Size(min = 3, max = 20, message = "Created by must have only 3-20 characters") String createdby,
            String password) {
        this.id = id;
        this.title = title;
        this.workspace = workspace;
        this.currentstatus = currentstatus;
        this.createdby = createdby;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWorkspace() {
        return workspace;
    }
    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }
    public String getCurrentstatus() {
        return currentstatus;
    }
    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }
    public String getCreatedby() {
        return createdby;
    }
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}