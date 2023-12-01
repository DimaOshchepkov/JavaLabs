package ru.oschepkov.transformbookstore;

import lombok.AllArgsConstructor;
import ru.oschepkov.bookstore.BookstoreXml;

@AllArgsConstructor
public class TransformCommandInvoker {
    ITransformCommand command;

    void setCommand(ITransformCommand command) {
        this.command = command;
    }

    BookstoreXml invoke(BookstoreXml bookstore) {
        return command.apply(bookstore);
    }
}
