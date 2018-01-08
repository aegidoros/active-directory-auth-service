package com.authenticationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
public class User implements Serializable{

    private static final long serialVersionUID = -4373208248762561992L;
    @JsonProperty(required = true)
    private long id;

    @JsonProperty (required = true)
    private String name;

    @JsonProperty (required = true)
    private String email;

    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getId(), getName(), getEmail(), getRoles());
    }
}
