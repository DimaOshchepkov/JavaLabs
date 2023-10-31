package ru.oschepkov;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IMapperBookstore {

    @Mapping(source = "bookstore.books", target = "books")
    ru.oschepkov.BookstoreNewStruct.Bookstore convert(ru.oschepkov.BookstoreStruct.Bookstore bookstore);
} 
