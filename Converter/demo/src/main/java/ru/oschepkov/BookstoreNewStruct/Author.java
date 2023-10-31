package ru.oschepkov.BookstoreNewStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

    @JacksonXmlProperty
    private String value;
}

