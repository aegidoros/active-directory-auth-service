package com.authenticationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
public class Right implements Serializable {

    private static final long serialVersionUID = 8909526301347809800L;


    @JsonProperty(required = true)
    private int idRight;

    private Timestamp dateCreated;

    private Timestamp dateUpdated;

    @JsonProperty (required = true)
    private String rightName;

    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Right)) return false;
        if (!super.equals(o)) return false;
        Right right = (Right) o;
        return getIdRight() == right.getIdRight() &&
                Objects.equals(getDateCreated(), right.getDateCreated()) &&
                Objects.equals(getDateUpdated(), right.getDateUpdated()) &&
                Objects.equals(getRightName(), right.getRightName()) &&
                Objects.equals(getRoles(), right.getRoles());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getIdRight(), getDateCreated(), getDateUpdated(), getRightName(), getRoles());
    }

}
