package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "Name is required")
    @NonNull
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Department is required")
    @NonNull
    @Column(name = "department")
    private String department;

    @NotBlank(message = "Description is required")
    @NonNull
    @Column(name = "description")
    private String description;

    @NotBlank(message = "State is required")
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_developer", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id"))
    private Set<Developer> developers;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_object", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "object_id", referencedColumnName = "id"))
    private Set<Object> objects;

    @JsonIgnore
    @OneToMany(mappedBy = "business_contact")
    private Set<BusinessContact> businessContacts;

    @JsonIgnore
    @OneToMany(mappedBy = "process")
    private Set<Process> processes;
}
