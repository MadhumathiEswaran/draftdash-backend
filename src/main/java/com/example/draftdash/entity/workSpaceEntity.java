package com.example.draftdash.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class workSpaceEntity {
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Workspace name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Min(value = 1, message = "Capacity limit must be at least 1")
    @Max(value = 1000, message = "Capacity limit must be less than or equal to 1000")
    private int capacitylimit;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    @NotBlank(message = "Owner name cannot be empty")
    private String owner;
    private String password;
    public workSpaceEntity() {
    }
    public workSpaceEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Workspace name cannot be empty") @Size(min = 3, max = 30, message = "Workspace name must have only 3-30 characters") String name,
            @NotBlank(message = "Description cannot be empty") @Size(min = 5, max = 100, message = "Description must have only 5-100 characters") String description,
            @Min(value = 1, message = "Capacity limit must be at least 1") @Max(value = 1000, message = "Capacity limit must be less than or equal to 1000") int capacitylimit,
            @NotBlank(message = "Status cannot be empty") String status,
            @NotBlank(message = "Owner name cannot be empty") @Size(min = 3, max = 20, message = "Owner name must have only 3-20 characters") String owner,
            String password) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacitylimit = capacitylimit;
        this.status = status;
        this.owner = owner;
        this.password = password;
    }
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCapacitylimit() {
        return capacitylimit;
    }
    public void setCapacitylimit(int capacitylimit) {
        this.capacitylimit = capacitylimit;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}