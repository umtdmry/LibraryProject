package com.Library.libraryproject.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
