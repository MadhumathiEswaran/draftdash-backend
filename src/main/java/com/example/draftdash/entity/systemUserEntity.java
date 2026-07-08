package com.example.draftdash.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class systemUserEntity {
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    @Max(value = 9999, message = "Id must be less than 10000")
    private Long id;

    @NotBlank(message = "Username cannot be empty")
   @Size(min = 3, max = 20, message = "Username must have only 3-20 characters")
    private String username;

    @NotBlank(message = "Email cannot be empty")
   @Email(message = "Enter a valid email address")
    private String email;

     @NotBlank(message = "Password cannot be empty")
    private String passwordhash;

    @NotNull(message = "Active status is required")
    private Boolean isactive;

    @NotNull(message = "Created date cannot be empty")
    private LocalDateTime createdat;

    public systemUserEntity() {
    }

    public systemUserEntity(
            @Min(value = 1, message = "Id must be greater than 0") @Max(value = 9999, message = "Id must be less than 10000") Long id,
            @NotBlank(message = "Username cannot be empty") @Size(min = 3, max = 20, message = "Username must have only 3-20 characters") String username,
            @NotBlank(message = "Email cannot be empty") @Email(message = "Enter a valid email address") String email,
            @NotBlank(message = "Password cannot be empty") @Size(min = 8, max = 20, message = "Password must have only 8-20 characters") String passwordhash,
            @NotNull(message = "Active status is required") Boolean isactive,
            @NotNull(message = "Created date cannot be empty") LocalDateTime createdat) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordhash = passwordhash;
        this.isactive = isactive;
        this.createdat = createdat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

}