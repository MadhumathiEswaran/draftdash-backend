package com.example.draftdash.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.draftdash.entity.reviewCycleEntity;
@Repository
public interface reviewcycleRepository extends JpaRepository<reviewCycleEntity,Long> {

}
