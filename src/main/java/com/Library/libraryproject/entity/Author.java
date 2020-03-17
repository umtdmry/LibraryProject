package com.Library.libraryproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    public void updateAuthor(Author author) {
        this.setName(author.getName());
        this.setDescription(author.getDescription());
    }
}
