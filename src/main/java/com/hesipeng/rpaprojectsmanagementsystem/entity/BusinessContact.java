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
@Table(name = "business_contact")
public class BusinessContact {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();

    @NotBlank(message = "First name is required")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email is required")
    @NonNull
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_business_contact", joinColumns = @JoinColumn(name = "business_contact_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
