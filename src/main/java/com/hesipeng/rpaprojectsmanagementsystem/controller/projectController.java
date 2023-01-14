package com.hesipeng.rpaprojectsmanagementsystem.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;
import com.hesipeng.rpaprojectsmanagementsystem.service.ProjectService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(UUID id) {
        return new ResponseEntity<>(projectService.getProject(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project) {
        return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable UUID id, @Valid @RequestBody Project project) {
        return new ResponseEntity<>(projectService.updateProject(id, project), HttpStatus.OK);
    }

    @PostMapping("/projectId/{projectId}/developerId/{developerId}")
    public ResponseEntity<Project> addDeveloperToProject(@PathVariable UUID projectId, @PathVariable UUID developerId) {
        return new ResponseEntity<>(projectService.addDeveloperToProject(projectId, developerId), HttpStatus.OK);
    }

    @DeleteMapping("/projectId/{projectId}/developerId/{developerId}")
    public ResponseEntity<Project> removeDeveloperFromProject(@PathVariable UUID projectId,
            @PathVariable UUID developerId) {
        return new ResponseEntity<>(projectService.removeDeveloperFromProject(projectId, developerId), HttpStatus.OK);
    }

    @PostMapping("/projectId/{projectId}/rpaObjectId/{rpaObjectId}")
    public ResponseEntity<Project> addRpaObjectToProject(@PathVariable UUID projectId, @PathVariable UUID rpaObjectId) {
        return new ResponseEntity<>(projectService.addRpaObjectToProject(projectId, rpaObjectId), HttpStatus.OK);
    }

    @DeleteMapping("/projectId/{projectId}/rpaObjectId/{rpaObjectId}")
    public ResponseEntity<Project> removeRpaObjectFromProject(@PathVariable UUID projectId,
            @PathVariable UUID rpaObjectId) {
        return new ResponseEntity<>(projectService.removeRpaObjectFromProject(projectId, rpaObjectId), HttpStatus.OK);
    }

}
