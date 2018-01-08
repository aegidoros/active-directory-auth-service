package com.authenticationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1361386411249346184L;
    @JsonProperty(required = true)
    private int idRole;

    private Timestamp dateCreated;

    private Timestamp dateUpdated;

    @JsonProperty (required = true)
    private String roleName;

    private List<Right> rights;


    private List<User> users;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return getIdRole() == role.getIdRole() &&
                Objects.equals(getDateCreated(), role.getDateCreated()) &&
                Objects.equals(getDateUpdated(), role.getDateUpdated()) &&
                Objects.equals(getRoleName(), role.getRoleName()) &&
                Objects.equals(getRights(), role.getRights()) &&
                Objects.equals(getUsers(), role.getUsers());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getIdRole(), getDateCreated(), getDateUpdated(), getRoleName(), getRights(), getUsers());
    }


}
