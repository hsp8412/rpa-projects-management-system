package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rpa_object")
public class RpaObject {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "is_utility")
    private Boolean isUtility;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_object", joinColumns = @JoinColumn(name = "object_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
