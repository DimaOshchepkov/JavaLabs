package ru.oschepkov.TransformBookstore;

import ru.oschepkov.BookstoreStruct.BookstoreXml;

@FunctionalInterface
public interface ITransformCommand {
    BookstoreXml apply(BookstoreXml bookstore);
}
