package com.Library.libraryproject.repository;

import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //public String findByName
}
