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
@Table(name = "business_contact")
public class BusinessContact {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_business_contact", joinColumns = @JoinColumn(name = "business_contact_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
