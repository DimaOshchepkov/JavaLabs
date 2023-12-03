package ru.oschepkov;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.oschepkov.bookstore.BookXml;
import ru.oschepkov.years.BookJson;

@Mapper
public interface MapperBook {
    
    @Mapping(target = ".", source = ".")
    BookXml convert(BookJson bookstore);

    @Mapping(target = ".", source = ".")
    BookJson convert(BookXml bookstore);
}
