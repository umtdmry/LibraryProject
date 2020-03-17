package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.entity.Category;
import com.Library.libraryproject.exception.CategoryNotFoundException;
import com.Library.libraryproject.repository.CategoryRepository;
import com.Library.libraryproject.service.BookService;
import com.Library.libraryproject.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final BookService bookService;

    public CategoryServiceImpl(CategoryRepository categoryRepository,@Lazy BookService bookService) {
        this.categoryRepository = categoryRepository;
        this.bookService = bookService;
    }

    @Override
    public List<Category> findCategoryByBookId(Long bookId) {
        return categoryRepository.findByBookId(bookId);
    }

    @Override
    public List<Category> findAllCategory() {
        log.info("Find All Category");
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category, long bookId) {
        Book book= bookService.getBookById(bookId);
        category.setBook(book);
        categoryRepository.save(category);
        log.info("Create Category !");
        return category;
    }

    @Override
    public void deleteCategory(long categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            log.info("Delete by id Category !");
        } catch (DataIntegrityViolationException exection) {
            log.info("Fail Delete category. Category is assigned to a book !");
        } catch (EmptyResultDataAccessException exception) {
            log.info("Fail Delete category. No categories found for this ID !");
        }

    }

    @Override
    public void editCategory(long categoryId, Category categoryBody) {
        Category category = getCategoryById(categoryId);
        category.updateCategory(categoryBody);
        this.categoryRepository.save(category);
        log.info("Update by id Category !");
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            log.info("Find by id category !");
            return category;
        } else {
            log.info("Not found by id category !");
            throw new CategoryNotFoundException("Not found by " + categoryId + " category");
        }
    }
}

