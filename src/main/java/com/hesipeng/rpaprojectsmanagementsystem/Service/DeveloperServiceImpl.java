package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.Repository.DeveloperRepository;
import com.hesipeng.rpaprojectsmanagementsystem.Repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;

public class DeveloperServiceImpl implements DeveloperService {

    DeveloperRepository developerRepository;
    ProjectRepository projectRepository;

    @Override
    public Developer getDeveloper(UUID id) {
        Optional<Developer> developer = developerRepository.findById(id);
        return unwrapBusinessContact(developer, id);
    }

    @Override
    public Set<Developer> getAllDevelopers() {
        return (Set<Developer>) developerRepository.findAll();
    }

    @Override
    public Set<Developer> getDevelopersByProjectId(UUID projectId) {
        return developerRepository.findByProjectId(projectId);
    }

    @Override
    public Developer updateDeveloper(UUID id, Developer developer) {
        Optional<Developer> developerWrapped = developerRepository.findById(id);
        Developer unwrappedDeveloper = unwrapBusinessContact(developerWrapped, id);
        unwrappedDeveloper.setFirstName(developer.getFirstName());
        unwrappedDeveloper.setLastName(developer.getLastName());
        unwrappedDeveloper.setEmail(developer.getEmail());
        unwrappedDeveloper.setIsActive(developer.getIsActive());
        return developerRepository.save(unwrappedDeveloper);
    }

    @Override
    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void deleteDeveloper(UUID id) {
        developerRepository.deleteById(id);
    }

    static Developer unwrapBusinessContact(Optional<Developer> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, Developer.class);
    }
}
