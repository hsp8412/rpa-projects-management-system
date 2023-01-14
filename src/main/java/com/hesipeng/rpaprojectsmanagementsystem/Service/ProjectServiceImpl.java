package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaObject;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;
import com.hesipeng.rpaprojectsmanagementsystem.repository.DeveloperRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.RpaObjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    DeveloperRepository developerRepository;
    RpaObjectRepository rpaObjectRepository;

    @Override
    public Project getProject(UUID id) {
        Optional<Project> project = projectRepository.findById(id);
        return unwrapProject(project, id);
    }

    @Override
    public Set<Project> getAllProjects() {
        return (Set<Project>) projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(UUID id, Project project) {
        Optional<Project> projectWrapped = projectRepository.findById(id);
        Project unwrappedProject = unwrapProject(projectWrapped, id);
        unwrappedProject.setName(project.getName());
        unwrappedProject.setDescription(project.getDescription());
        unwrappedProject.setDepartment(project.getDepartment());
        unwrappedProject.setState(project.getState());
        return projectRepository.save(unwrappedProject);
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }

    static Project unwrapProject(Optional<Project> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, Project.class);
    }

    @Override
    public Project addDeveloperToProject(UUID projectId, UUID developerId) {
        Project project = getProject(projectId);
        Optional<Developer> developer = developerRepository.findById(developerId);
        Developer unwrappedDeveloper = DeveloperServiceImpl.unwrapBusinessContact(developer, developerId);

        project.getDevelopers().add(unwrappedDeveloper);
        return projectRepository.save(project);
    }

    @Override
    public Project removeDeveloperFromProject(UUID projectId, UUID developerId) {
        Project project = getProject(projectId);
        Optional<Developer> developer = developerRepository.findById(developerId);
        Developer unwrappedDeveloper = DeveloperServiceImpl.unwrapBusinessContact(developer, developerId);

        project.getDevelopers().remove(unwrappedDeveloper);
        return projectRepository.save(project);
    }

    @Override
    public Project addRpaObjectToProject(UUID projectId, UUID rpaObjectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = unwrapProject(project, projectId);

        Optional<RpaObject> rpaObject = rpaObjectRepository.findById(rpaObjectId);
        RpaObject unwrappedRpaObject = RpaObjectServiceImpl.unwrapRpaObject(rpaObject, rpaObjectId);

        unwrappedProject.getRpaObjects().add(unwrappedRpaObject);
        return projectRepository.save(unwrappedProject);
    }

    @Override
    public Project removeRpaObjectFromProject(UUID projectId, UUID rpaObjectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = unwrapProject(project, projectId);

        Optional<RpaObject> rpaObject = rpaObjectRepository.findById(rpaObjectId);
        RpaObject unwrappedRpaObject = RpaObjectServiceImpl.unwrapRpaObject(rpaObject, rpaObjectId);

        unwrappedProject.getRpaObjects().remove(unwrappedRpaObject);
        return projectRepository.save(unwrappedProject);
    }

}
