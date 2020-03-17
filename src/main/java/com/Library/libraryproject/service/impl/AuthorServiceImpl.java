package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.exception.AuthorNotFoundException;
import com.Library.libraryproject.repository.AuthorRepository;
import com.Library.libraryproject.service.AuthorService;
import com.Library.libraryproject.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        log.info("Find all authors !");
        return authorRepository.findAll();
    }

    @Override
    public Author addAuthor(Author author) {
        authorRepository.save(author);
        log.info("Create author !");
        return author;
    }

    @Override
    public void deleteAuthor(long id) {
        try
        {
        authorRepository.deleteById(id);
        log.info("Delete author !");
        }
        catch (DataIntegrityViolationException exception)
        {
            log.info("Fail Delete author. Author is assigned to a book !");
        }
        catch (EmptyResultDataAccessException exception)
        {
            log.info("Fail Delete author. No authors found for this ID !");
        }
    }

    @Override
    public void editAuthor(long id, Author body) {
        Author author = getByIdAuthor(id);
        author.updateAuthor(body);
        this.authorRepository.save(author);
        log.info("Update by id author !");
    }

    @Override
    public Author getByIdAuthor(long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            log.info("Find by id author !");
            return author;
        } else {
            log.info("Not found by id author !");
            throw new AuthorNotFoundException("Not found by " + id + " author");
        }
    }
}
