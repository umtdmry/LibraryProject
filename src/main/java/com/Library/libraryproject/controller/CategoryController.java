package com.Library.libraryproject.controller;

import com.Library.libraryproject.dto.CategoryDTO;
import com.Library.libraryproject.entity.Category;
import com.Library.libraryproject.mapper.DtoMapper;
import com.Library.libraryproject.repository.BookRepository;
import com.Library.libraryproject.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final DtoMapper Mapper;

    public CategoryController(CategoryService categoryService, DtoMapper mapper) {
        this.categoryService = categoryService;
        this.Mapper = mapper;
    }

    @GetMapping("/books/{bookId}/categories")
    public List<Category> getCategoriesByBook(@PathVariable(value = "bookId") Long bookId) {
        return categoryService.findCategoryByBookId(bookId);
    }

    @GetMapping("/books/categories")
    public List<Category> getAllCategory(){
        return categoryService.findAllCategory();
    }

    @PostMapping("/books/{bookId}/categories")
    public ResponseEntity<String> createCategory(@PathVariable(value = "bookId") Long bookId, @RequestBody CategoryDTO categoryDTO) {
        Category category = Mapper.map(categoryDTO);
        categoryService.addCategory(category,bookId);
        return ResponseEntity.ok("Successful Registered !");
    }

    @PutMapping(value = "books/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable(value = "categoryId") long categoryId, @RequestBody CategoryDTO categoryDTO) {
        Category category =Mapper.map(categoryDTO);
        categoryService.editCategory(categoryId, category);
        return ResponseEntity.ok("Successful update");
    }

    @DeleteMapping(value = "books/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Successful delete");
    }
}

