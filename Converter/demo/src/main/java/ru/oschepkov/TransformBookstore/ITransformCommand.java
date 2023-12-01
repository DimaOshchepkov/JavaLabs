package ru.oschepkov.transformbookstore;

import ru.oschepkov.bookstore.BookstoreXml;

@FunctionalInterface
public interface ITransformCommand {
    BookstoreXml apply(BookstoreXml bookstore);
}
