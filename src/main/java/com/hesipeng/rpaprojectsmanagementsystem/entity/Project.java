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
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "department")
    private String department;

    @NonNull
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_developer", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id"))
    private Set<Developer> developers;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_business_contact", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "business_contact_id", referencedColumnName = "id"))
    private Set<BusinessContact> businessContacts;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_object", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "object_id", referencedColumnName = "id"))
    private Set<Object> objects;

    @JsonIgnore
    @OneToMany(mappedBy = "process")
    private Set<Process> processes;

}
