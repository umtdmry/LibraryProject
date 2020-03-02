package com.Library.libraryproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long authorId;

    private String authorName;

    private String authorDescription;


    public Author() {
    }

    public void updateAuthor(Author author) {
        this.setAuthorName(author.getAuthorName());
        this.setAuthorDescription(author.getAuthorDescription());
    }
}
