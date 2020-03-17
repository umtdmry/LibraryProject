package com.Library.libraryproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private int page;
    private String publishYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Category> categories = new ArrayList<>();

    public void updateBook(Book book) {
        this.setName(book.getName());
        this.setDescription(book.getDescription());
        this.setPage(book.getPage());
        this.setPublishYear(book.getPublishYear());
        this.setAuthor(book.getAuthor());
    }
}
