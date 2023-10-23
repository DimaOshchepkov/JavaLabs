package ru.oschepkov.BooksotreNewStruct;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Characters {

    @XmlElement(name = "character")
    private List<Character> books;
}