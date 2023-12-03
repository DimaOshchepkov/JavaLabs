package ru.oschepkov;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import lombok.val;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;

public class XMLTest {

    BookstoreInstance bookstoreInstance = new BookstoreInstance();

    @Test
    public void testEnglishRead() throws ReadFileException {
        val xml = new XML();
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\EnglishBookstore.xml");
        assertTrue(bookstore.getBooks().size() > 0);
    }

    @Test
    public void testRussianRead() throws ReadFileException {
        val xml = new XML();
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\RussianBookstore.xml");
        assertTrue(bookstore.getBooks().size() > 0);
    }

    @Test
    public void testWriteRussian() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getRussianBooks();
        val xml = new XML();
        xml.write("src\\test\\resources\\out\\bookstore.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.xml")).exists());
    }

    @Test
    public void testWriteEnglish() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getEnglishBooks();
        val xml = new XML();
        xml.write("src\\test\\resources\\out\\bookstore.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.xml")).exists());
    }

    @Test
    public void testWriteEncondingUtf_16() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getEnglishBooks();
        val xml = new XML("utf-16");
        xml.write("src\\test\\resources\\out\\bookstoreUtf_16.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstoreUtf_16.xml")).exists());
    }

    @Test
    public void testWriteEncondingWindows_1251() throws WriteFileException {
        BookstoreXml bookstore = bookstoreInstance.getRussianBooks();
        val xml = new XML("windows-1251");
        xml.write("src\\test\\resources\\out\\bookstoreWindows_1251.xml", bookstore);
        assertTrue((new File("src\\test\\resources\\out\\bookstoreWindows_1251.xml")).exists());
    }

    @Test
    public void testRussianReadUtf_16() throws ReadFileException {
        val xml = new XML("utf-16");
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\bookstoreUtf_16.xml");
        assertEquals(bookstore.getBooks().get(0).getCategory(), "Fantasy");
    }

    @Test
    public void testRussianReadWindows_1251() throws ReadFileException {
        val xml = new XML("windows-1251");
        BookstoreXml bookstore = xml.read("src\\test\\resources\\input\\bookstoreWindows_1251.xml");
        assertEquals(bookstore.getBooks().get(0).getCategory(), "Роман");
    }
}
