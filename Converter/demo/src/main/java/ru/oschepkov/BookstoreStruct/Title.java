package ru.oschepkov.BookstoreStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Title {

    @JacksonXmlProperty(isAttribute = true)
    private String lang;

    @JacksonXmlProperty
    private String value;
}



