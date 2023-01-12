package com.hesipeng.rpaprojectsmanagementsystem.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaObject;

public interface RpaObjectRepository extends CrudRepository<RpaObject, UUID> {
    Set<RpaObject> findByProjectId(UUID projectId);
}
