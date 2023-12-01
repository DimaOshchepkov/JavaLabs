package ru.oschepkov;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapperBook {
    
    @Mapping(target = ".", source = ".")
    ru.oschepkov.bookstore.BookXml convert(ru.oschepkov.years.BookJson bookstore);

    @Mapping(target = ".", source = ".")
    ru.oschepkov.years.BookJson convert(ru.oschepkov.bookstore.BookXml bookstore);
}
