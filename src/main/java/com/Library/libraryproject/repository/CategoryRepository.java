package com.Library.libraryproject.repository;


import com.Library.libraryproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByBookId(long bookId);
}
