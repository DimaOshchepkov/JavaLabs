package ru.oschepkov.bookstore;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookXml {

    @JacksonXmlProperty(isAttribute = true)
    private String category;
    private TitleXml title;
    private String author;
    private int year;
    private PriceXml price;

    @JacksonXmlProperty(localName = "character")
    @JacksonXmlElementWrapper(localName = "characters")
    private List<CharacterXml> characters;
}
