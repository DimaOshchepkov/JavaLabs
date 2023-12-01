package ru.oschepkov.bookstore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JacksonXmlRootElement(localName = "bookstore")
public class BookstoreXml {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("book")
    private List<BookXml> books;
}

