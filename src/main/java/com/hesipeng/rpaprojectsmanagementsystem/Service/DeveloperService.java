package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;

public interface DeveloperService {
    Developer getDeveloper(UUID id);

    Set<Developer> getAllDevelopers();

    Set<Developer> getDevelopersByProjectId(UUID projectId);

    Developer updateDeveloper(UUID id, Developer developer);

    Developer saveDeveloper(Developer developer);

    void deleteDeveloper(UUID id);
}
