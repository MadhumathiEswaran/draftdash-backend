package com.example.draftdash.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.draftdash.entity.auditLogEntity;
@Repository
public interface auditlogRepository extends JpaRepository<auditLogEntity,Long> {

}
