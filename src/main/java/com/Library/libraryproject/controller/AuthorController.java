package com.Library.libraryproject.controller;

import com.Library.libraryproject.dto.AuthorDTO;
import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.mapper.DtoMapper;
import com.Library.libraryproject.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final DtoMapper Mapper;

    public AuthorController(AuthorService authorService, DtoMapper mapper) {
        this.authorService = authorService;
        this.Mapper = mapper;
    }

    @GetMapping
    public List<Author> gelAllAuthor() {
        return authorService.findAllAuthors();
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = Mapper.map(authorDTO);
        authorService.addAuthor(author);
        return ResponseEntity.ok("Successful Registery !");
    }

    @DeleteMapping(value = "/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("authorId") long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok("Successful Delete !");
    }

    @PutMapping(value = "/{authorId}")
    public ResponseEntity<String> updateAuthor(@PathVariable("authorId") long authorId, @RequestBody AuthorDTO authorDTO) {
        Author author = Mapper.map(authorDTO);
        authorService.editAuthor(authorId, author);
        return ResponseEntity.ok("Successful Update !");
    }
}
