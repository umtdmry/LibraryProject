package com.Library.libraryproject.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue
    private long id;

    private String bookName;

    private String description;

    private int page;

    private Date publishYear;

    public Book() {
    }

    public void update(Book book) {
        this.setBookName(book.getBookName());
        this.setDescription(book.getDescription());
        this.setPage(book.getPage());
        this.setPublishYear(book.getPublishYear());
    }
}
