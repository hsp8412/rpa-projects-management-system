package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;
import com.hesipeng.rpaprojectsmanagementsystem.repository.DeveloperRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.ProjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
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
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = ProjectServiceImpl.unwrapProject(project, projectId);
        return unwrappedProject.getDevelopers();
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
