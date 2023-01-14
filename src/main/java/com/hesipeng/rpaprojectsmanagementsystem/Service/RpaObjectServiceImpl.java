package com.hesipeng.rpaprojectsmanagementsystem.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaObject;
import com.hesipeng.rpaprojectsmanagementsystem.exception.EntityNotFoundException;
import com.hesipeng.rpaprojectsmanagementsystem.repository.ProjectRepository;
import com.hesipeng.rpaprojectsmanagementsystem.repository.RpaObjectRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RpaObjectServiceImpl implements RpaObjectService {
    RpaObjectRepository rpaObjectRepository;
    ProjectRepository projectRepository;

    static RpaObject unwrapRpaObject(Optional<RpaObject> entity, UUID id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, RpaObject.class);
    }

    @Override
    public RpaObject getRpaObject(UUID id) {
        Optional<RpaObject> rpaObject = rpaObjectRepository.findById(id);
        return unwrapRpaObject(rpaObject, id);
    }

    @Override
    public Set<RpaObject> getRpaObjects() {
        return (Set<RpaObject>) rpaObjectRepository.findAll();
    }

    @Override
    public Set<RpaObject> getRpaObjectsByProjectId(UUID projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project unwrappedProject = ProjectServiceImpl.unwrapProject(project, projectId);
        return unwrappedProject.getRpaObjects();
    }

    @Override
    public RpaObject saveRpaObject(RpaObject rpaObject) {
        return rpaObjectRepository.save(rpaObject);
    }

    @Override
    public RpaObject updateRpaObject(RpaObject rpaObject, UUID id) {
        Optional<RpaObject> wrappedRpaObject = rpaObjectRepository.findById(id);
        RpaObject unwrappedRpaObject = unwrapRpaObject(wrappedRpaObject, id);
        unwrappedRpaObject.setName(rpaObject.getName());
        unwrappedRpaObject.setDescription(rpaObject.getDescription());
        unwrappedRpaObject.setIsUtility(rpaObject.getIsUtility());
        return rpaObjectRepository.save(unwrappedRpaObject);
    }

    @Override
    public void deleteRpaObject(UUID id) {
        rpaObjectRepository.deleteById(id);
    }

}
