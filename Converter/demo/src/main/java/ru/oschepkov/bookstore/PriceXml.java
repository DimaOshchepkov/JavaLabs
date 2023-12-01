package ru.oschepkov.bookstore;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceXml {

    @JacksonXmlProperty(isAttribute = true)
    private String currency;

    @JacksonXmlText
    private double value;
}
