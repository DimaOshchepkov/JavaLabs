package ru.oschepkov.BooksotreNewStruct;

import javax.xml.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "bookstore")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookstore {

    @XmlElement(name = "Year")
    private List<Year> years;
}
