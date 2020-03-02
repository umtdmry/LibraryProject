package com.Library.libraryproject.controller;

import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> gelAllAuthor() {
        return authorService.findAllAuthors();
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody Author authorBody) {
        authorService.addAuthor(authorBody);
        return ResponseEntity.ok("Successful Register !");
    }

    @DeleteMapping(value = "/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("authorId") long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok("Successful Delete !");
    }

    @PutMapping(value = "/{authorId}")
    public ResponseEntity<String> updateAuthor(@PathVariable("authorId") long authorId, Author authorBody) {
        authorService.editAuthor(authorId, authorBody);
        return ResponseEntity.ok("Successful Update !");
    }
}
