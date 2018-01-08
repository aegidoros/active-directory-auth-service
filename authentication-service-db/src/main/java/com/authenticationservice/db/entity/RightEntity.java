package com.authenticationservice.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="right")

public class RightEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_right", unique=true, nullable=false)
    private int idRight;

    @Column(name="date_created", nullable=false)
    private Timestamp dateCreated;

    @Column(name="date_updated")
    private Timestamp dateUpdated;

    @Column(name="right_name", nullable=false, length=45)
    private String rightName;

    //bi-directional many-to-many association to Role
    @ManyToMany(mappedBy="rights")
    private List<RoleEntity> roles;
}
