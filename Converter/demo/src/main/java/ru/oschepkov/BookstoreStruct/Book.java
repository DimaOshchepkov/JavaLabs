package ru.oschepkov.BookstoreStruct;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @JacksonXmlProperty(isAttribute = true)
    private String category;

    @JacksonXmlProperty
    private Title title;

    @JacksonXmlProperty
    private String author;

    @JacksonXmlProperty
    private String year;

    @JacksonXmlProperty
    private Price price;

    @JacksonXmlProperty
    private List<Character> characters;
}
