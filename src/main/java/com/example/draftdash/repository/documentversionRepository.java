package com.example.draftdash.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.draftdash.entity.documentVersionEntity;

@Repository
public interface documentversionRepository extends JpaRepository<documentVersionEntity,Long> {

}






