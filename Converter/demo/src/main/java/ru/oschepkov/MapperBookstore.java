package ru.oschepkov;

import ru.oschepkov.BookstoreNewStruct.YearJson;
import ru.oschepkov.BookstoreNewStruct.YearsJson;
import ru.oschepkov.BookstoreStruct.BookXml;
import ru.oschepkov.BookstoreStruct.BookstoreXml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapperBookstore {

    YearsJson convert(BookstoreXml bookstore) {
        MapperBook mapperBook = new MapperBookImpl();
        List<YearJson> years = new ArrayList();
        Map<Integer, List<BookXml>> map = bookstore.getBooks().stream()
            .collect(Collectors.groupingBy(BookXml::getYear));
        for (var entry : map.entrySet()) {
            YearJson year = YearJson.builder()
                .books(entry.getValue().stream()
                    .map(mapperBook::convert)
                    .collect(Collectors.toList()))
                .value(entry.getKey())
                .build();
            years.add(year);
        }
        return new YearsJson(years);
    } 

    BookstoreXml convert(YearsJson years) {
        MapperBook mapperBook = new MapperBookImpl();
        List<BookXml> books = new ArrayList();
        years.getYears().forEach(year -> {
            books.addAll(year.getBooks().stream()
                .map(mapperBook::convert)
                .collect(Collectors.toList()));
        });
        return new BookstoreXml(books);
    }
}
