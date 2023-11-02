package ru.oschepkov.BookstoreStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {

    @JacksonXmlProperty(isAttribute = true)
    private String currency;

    @JacksonXmlProperty
    private String value;
}
