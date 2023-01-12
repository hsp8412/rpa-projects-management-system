package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;

public interface BusinessContactService {
    // Retrieve
    BusinessContact getBusinessContact(UUID id);

    Set<BusinessContact> getBusinessContactsByProjectId(UUID projectId);

    // Create
    BusinessContact saveBusinessContactToProject(UUID projectId, BusinessContact businessContact);

    // Update
    BusinessContact updateBusinessContact(BusinessContact businessContact, UUID id);

    // Delete
    void deleteBusinessContact(UUID id);
}
