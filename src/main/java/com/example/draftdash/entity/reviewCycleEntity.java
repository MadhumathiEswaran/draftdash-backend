package com.example.draftdash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class reviewCycleEntity {
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Version cannot be empty")
    @Size(min = 2, max = 20, message = "Version must have only 2-20 characters")
    private String version;

    @NotBlank(message = "Assigned reviewer cannot be empty")
    @Size(min = 3, max = 30, message = "Assigned reviewer must have only 3-30 characters")
    private String assignedreviewer;

    @NotBlank(message = "Decision cannot be empty")
    @Size(min = 3, max = 20, message = "Decision must have only 3-20 characters")
    private String decision;

    @NotBlank(message = "Feedback notes cannot be empty")
    @Size(min = 5, max = 200, message = "Feedback notes must have only 5-200 characters")
    private String feedbacknotes;
    private String password;
    public reviewCycleEntity() {
    }
    public reviewCycleEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Version cannot be empty") @Size(min = 2, max = 20, message = "Version must have only 2-20 characters") String version,
            @NotBlank(message = "Assigned reviewer cannot be empty") @Size(min = 3, max = 30, message = "Assigned reviewer must have only 3-30 characters") String assignedreviewer,
            @NotBlank(message = "Decision cannot be empty") @Size(min = 3, max = 20, message = "Decision must have only 3-20 characters") String decision,
            @NotBlank(message = "Feedback notes cannot be empty") @Size(min = 5, max = 200, message = "Feedback notes must have only 5-200 characters") String feedbacknotes,
            String password) {
        this.id = id;
        this.version = version;
        this.assignedreviewer = assignedreviewer;
        this.decision = decision;
        this.feedbacknotes = feedbacknotes;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getAssignedreviewer() {
        return assignedreviewer;
    }
    public void setAssignedreviewer(String assignedreviewer) {
        this.assignedreviewer = assignedreviewer;
    }
    public String getDecision() {
        return decision;
    }
    public void setDecision(String decision) {
        this.decision = decision;
    }
    public String getFeedbacknotes() {
        return feedbacknotes;
    }
    public void setFeedbacknotes(String feedbacknotes) {
        this.feedbacknotes = feedbacknotes;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    

}
