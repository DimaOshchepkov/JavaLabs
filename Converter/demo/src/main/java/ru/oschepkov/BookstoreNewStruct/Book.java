package ru.oschepkov.BookstoreNewStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @JacksonXmlProperty
    private String category;

    @JacksonXmlProperty
    private Title title;

    @JacksonXmlProperty
    private Author author;

    @JacksonXmlProperty
    private Year year;

    @JacksonXmlProperty
    private Price price;
    
    @JacksonXmlProperty
    private Characters characters;
}
