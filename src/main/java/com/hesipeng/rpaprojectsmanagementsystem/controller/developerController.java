package com.hesipeng.rpaprojectsmanagementsystem.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;
import com.hesipeng.rpaprojectsmanagementsystem.service.DeveloperService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/developer")
public class DeveloperController {
    DeveloperService developerService;

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloper(UUID id) {
        return new ResponseEntity<>(developerService.getDeveloper(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerService.getAllDevelopers(), HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<Iterable<Developer>> getDevelopersByProjectId(@PathVariable UUID projectId) {
        return new ResponseEntity<>(developerService.getDevelopersByProjectId(projectId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Developer> saveDeveloper(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerService.saveDeveloper(developer), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable UUID id, @RequestBody Developer developer) {
        return new ResponseEntity<>(developerService.updateDeveloper(id, developer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDeveloper(@PathVariable UUID id) {
        developerService.deleteDeveloper(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
