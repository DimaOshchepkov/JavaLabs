package ru.oschepkov;

import ru.oschepkov.bookstore.BookXml;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.years.YearJson;
import ru.oschepkov.years.YearsJson;

import java.util.List;
import java.util.stream.Collectors;

import lombok.val;

public class MapperBookstore {

    public YearsJson convert(final BookstoreXml bookstore) {
        val mapperBook = new MapperBookImpl();
        
        final List<YearJson> years = bookstore.getBooks().stream()
            .collect(Collectors.groupingBy(BookXml::getYear))
            .entrySet().stream()
            .map(entry -> YearJson.builder()
                .value(entry.getKey())
                .books(entry.getValue().stream()
                    .map(mapperBook::convert)
                    .collect(Collectors.toList()))
                .build())
            .collect(Collectors.toList());
        
        return new YearsJson(years);
    }

    public BookstoreXml convert(final YearsJson years) {
        val mapperBook = new MapperBookImpl();
        
        final List<BookXml> books = years.getYears().stream()
            .flatMap(year -> year.getBooks().stream())
            .map(mapperBook::convert)
            .collect(Collectors.toList());
        
        return new BookstoreXml(books);
    }
}
