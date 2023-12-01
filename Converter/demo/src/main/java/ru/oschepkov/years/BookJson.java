package ru.oschepkov.years;

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
public class BookJson {

    @JacksonXmlProperty(isAttribute = true)
    private String category;
    private TitleJson title;
    private String author;
    private int year;
    private PriceJson price;
    
    @JacksonXmlProperty(localName = "character")
    @JacksonXmlElementWrapper(localName = "characters")
    private List<CharacterJson> characters;
}
