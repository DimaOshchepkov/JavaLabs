package ru.oschepkov.TransformBookstore;

import java.util.Comparator;
import java.util.stream.Collectors;

import ru.oschepkov.BookstoreStruct.BookstoreXml;

public class SortByBookName implements ITransformCommand {
    
    @Override
    public BookstoreXml apply(final BookstoreXml bookstore) {
        return new BookstoreXml(bookstore.getBooks().stream()
            .sorted(Comparator.comparing(book -> book.getTitle().getValue()))
            .collect(Collectors.toList()));
    }
}
