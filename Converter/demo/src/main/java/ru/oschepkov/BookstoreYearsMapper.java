package ru.oschepkov;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookstoreYearsMapper {

    //@Mapping(source = "firstName", target = "fullName")
    ru.oschepkov.BooksotreNewStruct.Bookstore personToPersonDTO(ru.oschepkov.BookstoreStruct.Bookstore person);

    //@Mapping(source = "fullName", target = "firstName")
    //@Mapping(target = "lastName", ignore = true)
    ru.oschepkov.BookstoreStruct.Bookstore personDTOToPerson(ru.oschepkov.BooksotreNewStruct.Bookstore personDTO);
    
}
