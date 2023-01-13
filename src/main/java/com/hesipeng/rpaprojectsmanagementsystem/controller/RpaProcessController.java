package com.hesipeng.rpaprojectsmanagementsystem.controller;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaProcess;
import com.hesipeng.rpaprojectsmanagementsystem.service.RpaProcessService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/process")
public class RpaProcessController {
    RpaProcessService rpaProcessService;

    @GetMapping("/all")
    public ResponseEntity<Set<RpaProcess>> getAllRpaProcesses() {
        return new ResponseEntity<>(rpaProcessService.getAllRpaProcesses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaProcess> getRpaProcess(UUID id) {
        return new ResponseEntity<>(rpaProcessService.getRpaProcess(id), HttpStatus.OK);
    }

    @GetMapping("/projectId/{projectId}")
    public ResponseEntity<Set<RpaProcess>> getRpaProcessesByProjectId(UUID projectId) {
        return new ResponseEntity<>(rpaProcessService.getRpaProcessesByProjectId(projectId), HttpStatus.OK);
    }

    @PostMapping("/projectId/{projectId}")
    public ResponseEntity<RpaProcess> saveRpaProcess(@PathVariable UUID projectId, @RequestBody RpaProcess rpaProcess) {
        return new ResponseEntity<>(rpaProcessService.saveRpaProcess(rpaProcess, projectId), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<RpaProcess> updateRpaProcess(@PathVariable UUID id, @RequestBody RpaProcess rpaProcess) {
        return new ResponseEntity<>(rpaProcessService.updateRpaProcess(rpaProcess, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRpaProcess(@PathVariable UUID id) {
        rpaProcessService.deleteRpaProcess(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
