package com.example.draftdash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class auditLogEntity {
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Actor cannot be empty")
    @Size(min = 3, max = 30, message = "Actor must have only 3-30 characters")
    private String actor;

    @NotBlank(message = "Action type cannot be empty")
    @Size(min = 3, max = 20, message = "Action type must have only 3-20 characters")
    private String actiontype;

    @NotBlank(message = "Target entity cannot be empty")
    @Size(min = 3, max = 30, message = "Target entity must have only 3-30 characters")
    private String targetentity;

    @Min(value = 1, message = "Target Id must be greater than 0")
    @Max(value = 9999, message = "Target Id must be less than 10000")
    private Long targetid;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 5, max = 200, message = "Description must have only 5-200 characters")
    private String description;
    private String password;
    public auditLogEntity() {
    }
    public auditLogEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Actor cannot be empty") @Size(min = 3, max = 30, message = "Actor must have only 3-30 characters") String actor,
            @NotBlank(message = "Action type cannot be empty") @Size(min = 3, max = 20, message = "Action type must have only 3-20 characters") String actiontype,
            @NotBlank(message = "Target entity cannot be empty") @Size(min = 3, max = 30, message = "Target entity must have only 3-30 characters") String targetentity,
            @Min(value = 1, message = "Target Id must be greater than 0") @Max(value = 9999, message = "Target Id must be less than 10000") Long targetid,
            @NotBlank(message = "Description cannot be empty") @Size(min = 5, max = 200, message = "Description must have only 5-200 characters") String description,
            String password) {
        this.id = id;
        this.actor = actor;
        this.actiontype = actiontype;
        this.targetentity = targetentity;
        this.targetid = targetid;
        this.description = description;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getActor() {
        return actor;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getActiontype() {
        return actiontype;
    }
    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }
    public String getTargetentity() {
        return targetentity;
    }
    public void setTargetentity(String targetentity) {
        this.targetentity = targetentity;
    }
    public Long getTargetid() {
        return targetid;
    }
    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
