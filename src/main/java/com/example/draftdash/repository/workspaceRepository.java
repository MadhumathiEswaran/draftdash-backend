package com.example.draftdash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.draftdash.entity.workSpaceEntity;

@Repository
public interface workspaceRepository extends JpaRepository<workSpaceEntity,Long> {

}
