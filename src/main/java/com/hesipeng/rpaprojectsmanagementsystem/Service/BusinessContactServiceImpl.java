package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;
import com.hesipeng.rpaprojectsmanagementsystem.repository.BusinessContactRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.ProjectRepository;

public class BusinessContactServiceImpl implements BusinessContactService {

    BusinessContactRepository businessContactRepository;
    ProjectRepository projectRepository;

    @Override
    public BusinessContact getBusinessContact(UUID id) {
        Optional<BusinessContact> businessContact = businessContactRepository.findById(id);
        return unwrapBusinessContact(businessContact, id);
    }

    @Override
    public Set<BusinessContact> getBusinessContactsByProjectId(UUID projectId) {
        return businessContactRepository.findByProjectId(projectId);
    }

    @Override
    public BusinessContact saveBusinessContactToProject(UUID projectId, BusinessContact businessContact) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = ProjectServiceImpl.unwrapProject(project, projectId);
        businessContact.setProject(unwrappedProject);
        return businessContactRepository.save(businessContact);
    }

    @Override
    public BusinessContact updateBusinessContact(BusinessContact businessContact, UUID id) {
        Optional<BusinessContact> businessContactWrapped = businessContactRepository.findById(id);
        BusinessContact unwrappedBusinessContact = unwrapBusinessContact(businessContactWrapped, id);
        unwrappedBusinessContact.setFirstName(businessContact.getFirstName());
        unwrappedBusinessContact.setLastName(businessContact.getLastName());
        unwrappedBusinessContact.setEmail(businessContact.getEmail());
        return businessContactRepository.save(unwrappedBusinessContact);
    }

    @Override
    public void deleteBusinessContact(UUID id) {
        businessContactRepository.deleteById(id);
    }

    static BusinessContact unwrapBusinessContact(Optional<BusinessContact> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, BusinessContact.class);
    }
}
