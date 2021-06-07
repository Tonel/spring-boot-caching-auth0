package com.caching.demo.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private static int id = 0;
    private String name;
    private String surname;
    private String birthDate;

    public Author() {}

    public Author(
            String name,
            String surname,
            String birthDate
    ) {
        id++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}