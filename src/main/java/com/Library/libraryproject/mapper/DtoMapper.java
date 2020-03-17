package com.Library.libraryproject.mapper;

import com.Library.libraryproject.dto.AuthorDTO;
import com.Library.libraryproject.dto.BookDTO;
import com.Library.libraryproject.dto.CategoryDTO;
import com.Library.libraryproject.entity.Author;
import com.Library.libraryproject.entity.Book;
import com.Library.libraryproject.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface DtoMapper {

    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    Book map(BookDTO book);

    BookDTO map(Book book);

    CategoryDTO map(Category category);

    Category map(CategoryDTO categoryDTO);

    AuthorDTO map(Author author);

    Author map(AuthorDTO authorDTO);

//   @Named("AuthorDTOtoAuthor")
//   default Author AuthorDTOtoAuthor(BookDTO bookDTO) {
//       AuthorDTO authorDTO= bookDTO.getAuthor();
//       Author author = new Author();
//       author.setId(authorDTO.getId());
//       author.setName(authorDTO.getName());
//       author.setDescription(authorDTO.getDescription());
//       return author;
//   }
//}
}
