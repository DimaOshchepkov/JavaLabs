package ru.oschepkov.BookstoreStruct;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
public class Year {

    @XmlValue
    private String value;

    // геттеры и сеттеры
}

