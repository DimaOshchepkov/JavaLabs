package ru.oschepkov;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapperBook {
    
    @Mapping(target = ".", source = ".")
    ru.oschepkov.BookstoreStruct.BookXml convert(ru.oschepkov.BookstoreNewStruct.BookJson bookstore);

    @Mapping(target = ".", source = ".")
    ru.oschepkov.BookstoreNewStruct.BookJson convert(ru.oschepkov.BookstoreStruct.BookXml bookstore);
}
