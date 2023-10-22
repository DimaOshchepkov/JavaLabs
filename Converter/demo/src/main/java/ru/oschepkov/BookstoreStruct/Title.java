package ru.oschepkov.BookstoreStruct;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
public class Title {

    @XmlAttribute
    private String lang;

    @XmlValue
    private String value;

    // геттеры и сеттеры
}



