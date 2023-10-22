package ru.oschepkov.BookstoreStruct;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @XmlAttribute
    private String category;

    private Title title;
    private Author author;
    private Year year;
    private Price price;
    private Characters characters;
}
