package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.Repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;

public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

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

}
