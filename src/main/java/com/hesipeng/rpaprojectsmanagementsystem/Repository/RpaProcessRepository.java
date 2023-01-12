package com.hesipeng.rpaprojectsmanagementsystem.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaProcess;

public interface RpaProcessRepository extends CrudRepository<RpaProcess, UUID> {
    Set<RpaProcess> findByProjectId(UUID projectId);
}
