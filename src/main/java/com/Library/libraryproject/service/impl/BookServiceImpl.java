package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.repository.AuthorRepository;
import com.Library.libraryproject.repository.BookRepository;
import com.Library.libraryproject.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Library.libraryproject.exception.bookNotFoundException;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        log.info("Find all books !");
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        Author author = this.authorRepository.getByAuthorId(book.getAuthor().getAuthorId());
        book.setAuthor(author);
        bookRepository.save(book);
        log.info("Create book !");
        return book;
    }

    @Override
    public void deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
        log.info("Delete by id book !");
    }

    @Override
    public void editBook(long bookId, Book bookBody) {
        Book book = getBookById(bookId);
        book.updateBook(bookBody);
        this.bookRepository.save(book);
        log.info("Update by id book !");
    }

    @Override
    public Book getBookById(long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            log.info("Find by id book !");
            return book;
        } else {
            log.info("Not found by id book !");
            throw new bookNotFoundException("Not found by " + bookId + " book");
        }
    }

    //@Override
    //public Book getBookByName(String bookName) {
    //   Book book = bookRepository.findByName(bookName).orElse(null);
    //   if (book != null) {
    //       log.info("Find by id book !");
    //       return book;
    //   } else {
    //       log.info("Not found by id book !");
    //       throw new bookNotFoundException("Not found by " + bookName + " book");
    //   }
    //
    //}

}
