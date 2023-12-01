package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;

public class XMLTest {

    BookstoreInstance bookstoreInstance = new BookstoreInstance();

    @Test
    public void testEnglishRead() throws ReadFileException {
        XML xml = new XML();
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\EnglishBookstore.xml");
        assertTrue(bookstore.getBooks().size() > 0);
    }

    @Test
    public void testRussianRead() throws ReadFileException {
        XML xml = new XML();
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\RussianBookstore.xml");
        assertTrue(bookstore.getBooks().size() > 0);
    }

    @Test
    public void testWriteRussian() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getRussianBooks();
        XML xml = new XML();
        xml.write("src\\test\\resources\\out\\bookstore.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.xml")).exists());
    }

    @Test
    public void testWriteEnglish() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getEnglishBooks();
        XML xml = new XML();
        xml.write("src\\test\\resources\\out\\bookstore.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.xml")).exists());
    }
}
