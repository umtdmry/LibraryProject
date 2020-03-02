package com.Library.libraryproject.service;

import com.Library.libraryproject.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();

    Author addAuthor(Author author);

    void deleteAuthor(long authorId);

    void editAuthor(long authorId, Author authorBody);

    Author getByIdAuthor(long authorId);
}
