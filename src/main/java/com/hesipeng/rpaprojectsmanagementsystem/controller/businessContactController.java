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

import com.hesipeng.rpaprojectsmanagementsystem.entity.BusinessContact;
import com.hesipeng.rpaprojectsmanagementsystem.service.BusinessContactService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/business_contact")
public class businessContactController {
    BusinessContactService businessContactService;

    @GetMapping("/{id}")
    public ResponseEntity<BusinessContact> getBusinessContact(UUID id) {
        return new ResponseEntity<>(businessContactService.getBusinessContact(id), HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<Iterable<BusinessContact>> getBusinessContactsByProjectId(@PathVariable UUID projectId) {
        return new ResponseEntity<>(businessContactService.getBusinessContactsByProjectId(projectId), HttpStatus.OK);
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<BusinessContact> saveBusinessContactToProject(@RequestBody BusinessContact businessContact,
            @PathVariable UUID projectId) {
        return new ResponseEntity<>(businessContactService.saveBusinessContactToProject(projectId, businessContact),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<BusinessContact> updateBusinessContact(@PathVariable UUID id,
            @RequestBody BusinessContact businessContact) {
        return new ResponseEntity<>(businessContactService.updateBusinessContact(businessContact, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBusinessContact(@PathVariable UUID id) {
        businessContactService.deleteBusinessContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
