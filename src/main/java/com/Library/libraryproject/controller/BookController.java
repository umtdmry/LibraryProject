package com.Library.libraryproject.controller;

import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping()
    public ResponseEntity<String> createBook(@RequestBody Book bookBody) {
        bookService.addBook(bookBody);
        return ResponseEntity.ok("Successful Registered !");
    }

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable("bookId") long bookId, @RequestBody Book bookBody) {
        bookService.editBook(bookId, bookBody);
        return ResponseEntity.ok("Successful update");
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Successful delete");
    }
}
