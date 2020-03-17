package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.entity.Category;
import com.Library.libraryproject.repository.AuthorRepository;
import com.Library.libraryproject.repository.BookRepository;
import com.Library.libraryproject.repository.CategoryRepository;
import com.Library.libraryproject.service.AuthorService;
import com.Library.libraryproject.service.BookService;
import com.Library.libraryproject.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.Library.libraryproject.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;


    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public List<Book> findAllBooks() {
        log.info("Find all books !");
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        Author author = this.authorService.getByIdAuthor(book.getAuthor().getId());
        book.setAuthor(author);
        bookRepository.save(book);
        log.info("Create book !");
        return book;
    }

    @Override
    public void deleteBook(long bookId) {
        Book book = getBookById(bookId);
        book.setAuthor(null);
        bookRepository.deleteById(bookId);
        log.info("Delete by id book !");
    }

    @Override
    public void editBook(long bookId, Book bookBody) {
        Book book = getBookById(bookId);
        Author author = this.authorService.getByIdAuthor(bookBody.getAuthor().getId());
        bookBody.setAuthor(author);

//        bookBody.getCategories().forEach(category -> {
//            Category currentCategory = categoryRepository.getOne(category.getId());
//            bookBody.getCategories().add(currentCategory);
//        });
//
//        List<Category> categories = new ArrayList<>();
//        bookBody.getCategories().forEach(category -> {
//            categories.add(categoryRepository.getOne(category.getId()));
//        });
//        bookBody.setCategories(categories);

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
            throw new BookNotFoundException("Not found by " + bookId + " book");
        }
    }
}
