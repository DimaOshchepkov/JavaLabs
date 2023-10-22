package ru.oschepkov.BooksotreNewStruct;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
public class Year {

    @XmlAttribute
    private String value;

    private List<Book> books;
}

