package ru.oschepkov.BookstoreStruct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookstore {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Book> books;
}

