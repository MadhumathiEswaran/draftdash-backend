package com.example.draftdash.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.draftdash.entity.authenticationEntity;

public interface authenticationRepository extends JpaRepository<authenticationEntity, Long> {

    Optional<authenticationEntity> findByEmail(String email);
}