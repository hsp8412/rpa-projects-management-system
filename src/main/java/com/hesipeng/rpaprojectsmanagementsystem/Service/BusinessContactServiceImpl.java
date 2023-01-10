package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.Repository.BusinessContactRepository;
import com.hesipeng.rpaprojectsmanagementsystem.Repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;

public class BusinessContactServiceImpl implements BusinessContactService {

    BusinessContactRepository businessContactRepository;
    ProjectRepository projectRepository;

    @Override
    public BusinessContact getBusinessContact(UUID id) {
        Optional<BusinessContact> businessContact = businessContactRepository.findById(id);
        return unwrapBusinessContact(businessContact, id);
    }

    @Override
    public Set<BusinessContact> getBusinessContactByProjectId(UUID projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
    }

    @Override
    public void addBusinessContactToProject(UUID projectId, BusinessContact businessContact) {
        // TODO Auto-generated method stub

    }

    @Override
    public BusinessContact updateBusinessContact(BusinessContact businessContact, UUID BusinessContactId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteBusinessContact(UUID id) {
        // TODO Auto-generated method stub

    }

    static BusinessContact unwrapBusinessContact(Optional<BusinessContact> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, BusinessContact.class);
    }

}
