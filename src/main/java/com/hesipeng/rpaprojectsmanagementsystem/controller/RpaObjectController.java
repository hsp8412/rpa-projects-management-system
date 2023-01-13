package com.hesipeng.rpaprojectsmanagementsystem.controller;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hesipeng.rpaprojectsmanagementsystem.entity.RpaObject;
import com.hesipeng.rpaprojectsmanagementsystem.service.RpaObjectService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/object")
public class RpaObjectController {
    RpaObjectService rpaObjectService;

    @GetMapping("/all")
    public ResponseEntity<Set<RpaObject>> getAllRpaObjects() {
        return new ResponseEntity<>(rpaObjectService.getRpaObjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaObject> getRpaObject(UUID id) {
        return new ResponseEntity<>(rpaObjectService.getRpaObject(id), HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<Set<RpaObject>> getRpaObjectsByProjectId(UUID projectId) {
        return new ResponseEntity<>(rpaObjectService.getRpaObjectsByProjectId(projectId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RpaObject> saveRpaObject(@RequestBody RpaObject rpaObject) {
        return new ResponseEntity<>(rpaObjectService.saveRpaObject(rpaObject), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<RpaObject> updateRpaObject(UUID id, @RequestBody RpaObject rpaObject) {
        return new ResponseEntity<>(rpaObjectService.updateRpaObject(rpaObject, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRpaObject(UUID id) {
        rpaObjectService.deleteRpaObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
