package com.Library.libraryproject.service.impl;

import com.Library.libraryproject.entity.Category;
import com.Library.libraryproject.exception.categoryNotFoundException;
import com.Library.libraryproject.repository.CategoryRepository;
import com.Library.libraryproject.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        log.info("Create Category !");
        return category;
    }

    @Override
    public void deleteCategory(long categoryId) {
        categoryRepository.deleteById(categoryId);
        log.info("Delete by id Category !");
    }

    @Override
    public void editCategory(long categoryId, Category categoryBody) {
        Category category = getCategoryById(categoryId);
        category.updateCategory(categoryBody);
        this.categoryRepository.save(category);
        log.info("Update by id Category !");
    }

    @Override
    public Category getCategoryById(long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            log.info("Find by id category !");
            return category;
        } else {
            log.info("Not found by id category !");
            throw new categoryNotFoundException("Not found by " + categoryId + " category");
        }
    }

}
