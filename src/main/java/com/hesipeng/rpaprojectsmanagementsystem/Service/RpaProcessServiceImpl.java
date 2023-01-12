package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaProcess;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;
import com.hesipeng.rpaprojectsmanagementsystem.repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.RpaProcessRepository;

public class RpaProcessServiceImpl implements RpaProcessService {

    RpaProcessRepository rpaProcessRepository;
    ProjectRepository projectRepository;

    static RpaProcess unwrapRpaProcess(Optional<RpaProcess> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, RpaProcess.class);
    }

    @Override
    public RpaProcess getRpaProcess(UUID id) {
        Optional<RpaProcess> process = rpaProcessRepository.findById(id);
        return unwrapRpaProcess(process, id);
    }

    @Override
    public Set<RpaProcess> getAllRpaProcesses() {
        return (Set<RpaProcess>) rpaProcessRepository.findAll();
    }

    @Override
    public Set<RpaProcess> getRpaProcessesByProjectId(UUID projectId) {
        return rpaProcessRepository.findByProjectId(projectId);
    }

    @Override
    public RpaProcess saveRpaProcess(RpaProcess rpaProcess, UUID projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = ProjectServiceImpl.unwrapProject(project, projectId);
        rpaProcess.setProject(unwrappedProject);
        return rpaProcessRepository.save(rpaProcess);
    }

    @Override
    public RpaProcess updateRpaProcess(RpaProcess rpaProcess, UUID id) {
        Optional<RpaProcess> rpaProcessWrapped = rpaProcessRepository.findById(id);
        RpaProcess unwrappedRpaProcess = unwrapRpaProcess(rpaProcessWrapped, id);
        unwrappedRpaProcess.setName(rpaProcess.getName());
        unwrappedRpaProcess.setDescription(rpaProcess.getDescription());
        unwrappedRpaProcess.setProcessType(rpaProcess.getProcessType());
        return rpaProcessRepository.save(unwrappedRpaProcess);
    }

    @Override
    public void deleteRpaProcess(UUID id) {
        rpaProcessRepository.deleteById(id);
    }

}
