package com.Library.libraryproject.service;

import com.Library.libraryproject.dto.BookDTO;
import com.Library.libraryproject.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    Book addBook(Book book);

    void deleteBook(long bookId);

    void editBook(long bookId, Book bookBody);

    Book getBookById(long bookId);
}
