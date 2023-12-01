package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.years.YearsJson;

public class MapperBookstoreTest {

    MapperBookstore mapper = new MapperBookstore();
    YearsInstance yearsInstance = new YearsInstance();
    BookstoreInstance bookstoreInstance = new BookstoreInstance();

    @Test
    public void testConvertToYears() {
        YearsJson years = mapper.convert(bookstoreInstance.getEnglishBooks());
        assertTrue(years.getYears().size() > 0);
    }

    @Test
    public void testConvert2() {
        BookstoreXml bookstore = mapper.convert(yearsInstance.getEnglishBooksByYears());
        assertTrue(bookstore.getBooks().size() > 0);
    }
}
