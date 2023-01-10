package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_developer", joinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
