package ru.oschepkov.BookstoreNewStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {

    @JacksonXmlProperty
    private String name;
    
    @JacksonXmlProperty
    private String role;
}
