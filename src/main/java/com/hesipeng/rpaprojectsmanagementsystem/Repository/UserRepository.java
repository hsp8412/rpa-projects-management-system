package com.hesipeng.rpaprojectsmanagementsystem.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hesipeng.rpaprojectsmanagementsystem.entity.User;

public interface UserRepository extends CrudRepository<User, UUID> {

}
