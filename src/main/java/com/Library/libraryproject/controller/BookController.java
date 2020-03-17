package com.Library.libraryproject.controller;

import com.Library.libraryproject.dto.BookDTO;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.mapper.DtoMapper;
import com.Library.libraryproject.service.BookService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final DtoMapper Mapper;

    public BookController(BookService bookService, DtoMapper Mapper) {
        this.bookService = bookService;
        this.Mapper = Mapper;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping()
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
        Book book = Mapper.map(bookDTO);
        bookService.addBook(book);
        return ResponseEntity.ok("Successful Registered !");
    }

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable("bookId") long bookId, @RequestBody BookDTO bookDTO) {
        Book book = Mapper.map(bookDTO);
        bookService.editBook(bookId, book);
        return ResponseEntity.ok("Successful update");
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Successful delete");
    }
}
