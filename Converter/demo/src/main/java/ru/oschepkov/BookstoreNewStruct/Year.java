package ru.oschepkov.BookstoreNewStruct;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Year {

    @JacksonXmlProperty
    private String value;

    @JacksonXmlProperty
    private List<Book> books;
}
