package com.Library.libraryproject.service;

import com.Library.libraryproject.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category addCategory(Category category);

    void deleteCategory(long categoryId);

    void editCategory(long categoryId, Category categoryBody);

    Category getCategoryById(long categoryId);
}
