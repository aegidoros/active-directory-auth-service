package com.authenticationservice.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user", unique=true, nullable=false)
    private long id;

    @Column(nullable=false)
    private String userName;

    @Column(nullable=false, length=100)
    private String email;

    //bi-directional many-to-many association to Role
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="user_role"
            , joinColumns={
            @JoinColumn(name="id_user", nullable=false)
    }
            , inverseJoinColumns={
            @JoinColumn(name="id_role", nullable=false)
    }
    )
    private List<RoleEntity> roles;
}
