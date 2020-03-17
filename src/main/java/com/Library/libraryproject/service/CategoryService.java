package com.Library.libraryproject.service;

import com.Library.libraryproject.dto.CategoryDTO;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findCategoryByBookId(Long bookId);

    List<Category> findAllCategory();

    Category addCategory(Category category, long bookId);

    void deleteCategory(long categoryId);

    void editCategory(long categoryId, Category categoryBody);

    Category getCategoryById(Long categoryId);

}
