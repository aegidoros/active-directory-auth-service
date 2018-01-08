package com.authenticationservice.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", unique = true, nullable = false)
    private int idRole;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "date_updated")
    private Timestamp dateUpdated;

    @Column(name = "role_name", nullable = false, length = 45)
    private String roleName;

    //bi-directional many-to-many association to Right
    @ManyToMany
    @JoinTable(
            name = "role_right"
            , joinColumns = {
            @JoinColumn(name = "id_role", nullable = false)
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "id_right", nullable = false)
    }
    )
    private List<RightEntity> rights;

    //bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
}
