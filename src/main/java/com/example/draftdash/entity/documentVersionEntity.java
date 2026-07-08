package com.example.draftdash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class documentVersionEntity {
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, max = 50, message = "Title must have only 3-50 characters")
    private String title;

    @Min(value = 1, message = "Version number must be at least 1")
    @Max(value = 100, message = "Version number must be less than or equal to 100")
    private Integer versionnumber;

    @NotBlank(message = "Content delta cannot be empty")
    @Size(min = 5, max = 500, message = "Content delta must have only 5-500 characters")
    private String contentdelta;

    @NotBlank(message = "Commit message cannot be empty")
    @Size(min = 5, max = 100, message = "Commit message must have only 5-100 characters")
    private String commitmessage;

    @NotBlank(message = "Author cannot be empty")
    @Size(min = 3, max = 30, message = "Author name must have only 3-30 characters")
    private String author;
    private String password;
    public documentVersionEntity() {
    }
    public documentVersionEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Title cannot be empty") @Size(min = 3, max = 50, message = "Title must have only 3-50 characters") String title,
            @Min(value = 1, message = "Version number must be at least 1") @Max(value = 100, message = "Version number must be less than or equal to 100") Integer versionnumber,
            @NotBlank(message = "Content delta cannot be empty") @Size(min = 5, max = 500, message = "Content delta must have only 5-500 characters") String contentdelta,
            @NotBlank(message = "Commit message cannot be empty") @Size(min = 5, max = 100, message = "Commit message must have only 5-100 characters") String commitmessage,
            @NotBlank(message = "Author cannot be empty") @Size(min = 3, max = 30, message = "Author name must have only 3-30 characters") String author,
            String password) {
        this.id = id;
        this.title = title;
        this.versionnumber = versionnumber;
        this.contentdelta = contentdelta;
        this.commitmessage = commitmessage;
        this.author = author;
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
    public Integer getVersionnumber() {
        return versionnumber;
    }
    public void setVersionnumber(Integer versionnumber) {
        this.versionnumber = versionnumber;
    }
    public String getContentdelta() {
        return contentdelta;
    }
    public void setContentdelta(String contentdelta) {
        this.contentdelta = contentdelta;
    }
    public String getCommitmessage() {
        return commitmessage;
    }
    public void setCommitmessage(String commitmessage) {
        this.commitmessage = commitmessage;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}