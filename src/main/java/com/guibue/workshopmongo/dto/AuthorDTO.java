package com.guibue.workshopmongo.dto;

import com.guibue.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    public static final long serialVersionUID = 1L;
    private String id;

    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return id.equals(authorDTO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
