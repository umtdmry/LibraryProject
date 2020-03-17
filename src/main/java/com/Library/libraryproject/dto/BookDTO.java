package com.Library.libraryproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    private String name;

    private String description;

    private int page;

    private String publishYear;

    private AuthorDTO author;

    private List<CategoryDTO> categories;
}