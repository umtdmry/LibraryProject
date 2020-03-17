package com.Library.libraryproject.repository;

import com.Library.libraryproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBookById(Long bookId);
}
