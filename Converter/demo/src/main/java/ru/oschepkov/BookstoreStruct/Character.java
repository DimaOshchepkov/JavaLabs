package ru.oschepkov.BookstoreStruct;

import javax.xml.bind.annotation.XmlAccessorType;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
public class Character {

    private String name;
    private String role;

    // геттеры и сеттеры
}
