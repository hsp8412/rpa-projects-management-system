package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaProcess;

public interface RpaProcessService {

    // Retrieve
    RpaProcess getRpaProcess(UUID id);

    Set<RpaProcess> getAllRpaProcesses();

    Set<RpaProcess> getRpaProcessesByProjectId(UUID projectId);

    // Create
    RpaProcess saveRpaProcess(RpaProcess rpaProcess, UUID projectId);

    // Update
    RpaProcess updateRpaProcess(RpaProcess rpaProcess, UUID id);

    // Delete
    void deleteRpaProcess(UUID id);
}
