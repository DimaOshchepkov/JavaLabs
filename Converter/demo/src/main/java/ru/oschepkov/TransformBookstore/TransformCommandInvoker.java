package ru.oschepkov.TransformBookstore;

import lombok.AllArgsConstructor;
import ru.oschepkov.BookstoreStruct.BookstoreXml;

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
