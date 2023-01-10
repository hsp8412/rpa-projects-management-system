package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;

public interface BusinessContactService {
    BusinessContact getBusinessContact(UUID id);

    Set<BusinessContact> getBusinessContactByProjectId(UUID projectId);

    void addBusinessContactToProject(UUID projectId, BusinessContact businessContact);

    BusinessContact updateBusinessContact(BusinessContact businessContact, UUID BusinessContactId);

    void deleteBusinessContact(UUID id);
}
