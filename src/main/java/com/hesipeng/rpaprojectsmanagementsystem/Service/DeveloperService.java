package com.hesipeng.rpaprojectsmanagementsystem.Service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;

public interface DeveloperService {
    Developer getDeveloper(UUID id);

    Set<Developer> getAllDevelopers();

    Set<Developer> getDevelopersByProjectId(UUID projectId);

    void updateDeveloper(UUID id, Developer developer);

    void addDeveloper(Developer developer);

    void deleteDeveloper(UUID id);

    void addDeveloperToProject(UUID projectId, UUID developerId);

    void removeDeveloperFromProject(UUID projectId, UUID developerId);
}
