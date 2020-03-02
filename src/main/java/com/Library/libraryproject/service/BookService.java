package com.Library.libraryproject.service;

import com.Library.libraryproject.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book add(Book book);
    void delete(long id);
    void edit(long id, Book bookBody);
    Book getBookById(long id);
    Book getBookByName(Book book);
}
