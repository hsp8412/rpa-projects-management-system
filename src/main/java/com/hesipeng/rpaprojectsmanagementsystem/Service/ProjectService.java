package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;

public interface ProjectService {
    Project getProject(UUID id);

    Set<Project> getAllProjects();

    Project saveProject(Project project);

    Project updateProject(UUID id, Project project);

    void deleteProject(UUID id);
}
