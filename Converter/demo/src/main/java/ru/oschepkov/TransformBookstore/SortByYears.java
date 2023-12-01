package ru.oschepkov.transformbookstore;

import java.util.Comparator;
import java.util.stream.Collectors;

import ru.oschepkov.bookstore.BookXml;
import ru.oschepkov.bookstore.BookstoreXml;

public class SortByYears implements ITransformCommand{

    @Override
    public BookstoreXml apply(final BookstoreXml bookstore) {
       return new BookstoreXml(bookstore.getBooks().stream()
            .sorted(Comparator.comparing(BookXml::getYear))
            .collect(Collectors.toList()));
    }
    
}
