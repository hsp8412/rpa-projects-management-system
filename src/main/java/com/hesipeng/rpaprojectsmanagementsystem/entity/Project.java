package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
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
    private Set<RpaObject> RpaObjects;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<BusinessContact> businessContacts;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    private Set<RpaProcess> rpaProcesses;
}
