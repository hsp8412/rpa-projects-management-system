package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "process")
public class Process {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "process_type")
    private ProcessType processType;

    @NonNull
    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
}
