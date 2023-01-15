package com.hesipeng.rpaprojectsmanagementsystem.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "is_admin")
    private Boolean isAdmin;
}
