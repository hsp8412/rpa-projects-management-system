package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaObject;

public interface RpaObjectService {
    // Retrieve
    RpaObject getRpaObject(UUID id);

    Set<RpaObject> getRpaObjects();

    Set<RpaObject> getRpaObjectsByProjectId(UUID projectId);

    // Create
    RpaObject saveRpaObject(RpaObject rpaObject);

    // Update
    RpaObject updateRpaObject(RpaObject rpaObject, UUID id);

    // Delete
    void deleteRpaObject(UUID id);
}
