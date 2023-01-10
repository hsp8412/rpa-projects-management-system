package com.hesipeng.rpaprojectsmanagementsystem.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, UUID> {

}
