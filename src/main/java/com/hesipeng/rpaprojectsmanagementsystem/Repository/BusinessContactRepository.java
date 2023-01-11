package com.hesipeng.rpaprojectsmanagementsystem.Repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;

public interface BusinessContactRepository extends CrudRepository<BusinessContact, UUID> {
    Set<BusinessContact> findByProjectId(UUID projectId);
}
