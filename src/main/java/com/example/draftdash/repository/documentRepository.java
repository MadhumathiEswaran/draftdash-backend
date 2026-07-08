package com.example.draftdash.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.draftdash.entity.documentEntity;

@Repository
public interface documentRepository extends JpaRepository<documentEntity,Long> {

}
