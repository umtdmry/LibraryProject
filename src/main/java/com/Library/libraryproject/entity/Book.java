package com.Library.libraryproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private int page;
    private String publishYear;

    //cascade = CascadeType.ALL= Alt nesnelere ait bütün işlemleri tek bir işlemde yapar.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;

    public Book() {
    }

    public void updateBook(Book book) {
        this.setName(book.getName());
        this.setDescription(book.getDescription());
        this.setPage(book.getPage());
        this.setPublishYear(book.getPublishYear());
    }
}
