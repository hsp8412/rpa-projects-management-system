package com.hesipeng.rpaprojectsmanagementsystem.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, UUID> {

}
