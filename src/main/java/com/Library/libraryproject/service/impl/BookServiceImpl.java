package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.repository.BookRepository;
import com.Library.libraryproject.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.Library.libraryproject.exception.bookNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        log.info("Find all products !");
        return bookRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        bookRepository.save(book);
        log.info("Find all products !");
        return book;
    }

    @Override
    public void delete(long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
        log.info("Delete by id book !");
    }

    @Override
    public void edit(long id, Book bookBody) {
        Book book = getBookById(id);
        book.update(bookBody);
        this.bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> bookopt = bookRepository.findById(id);
        if (bookopt.isPresent()) {
            log.info("Find by id book !");
            return bookopt.get();
        } else {
            log.info("Not found by id book !");
            throw new bookNotFoundException("Not found by " + id + " book");
        }
    }

    @Override
    public Book getBookByName(Book book) {
        return null;
    }

}
