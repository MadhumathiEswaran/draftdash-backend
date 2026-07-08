package com.example.draftdash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.draftdash.entity.systemUserEntity;

@Repository
public interface systemuserRepository extends JpaRepository<systemUserEntity,Long> {

}
