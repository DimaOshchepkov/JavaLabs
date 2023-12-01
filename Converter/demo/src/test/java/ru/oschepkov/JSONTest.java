package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;
import ru.oschepkov.years.YearsJson;

public class JSONTest {
    YearsInstance yearsInstance = new YearsInstance();

    @Test
    public void testEnglishRead() throws ReadFileException {
        JSON json = new JSON();
        YearsJson years = json.read("src\\test\\resources\\input\\EnglishBooksByYears.json");
        assertTrue(years.getYears().size() > 0);
    }

    @Test
    public void testRussianRead() throws ReadFileException {
        JSON json = new JSON();
        YearsJson years= json.read("src\\test\\resources\\input\\RussianBooksByYears.json");
        assertTrue(years.getYears().size() > 0);
    }

    @Test
    public void testWriteRussian() throws WriteFileException {
        YearsJson years = yearsInstance.getRussianBooksByYears();
        JSON json = new JSON();
        json.write("src\\test\\resources\\out\\bookstore.xml", years);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.xml")).exists());
    }

    @Test
    public void testWriteEnglish() throws WriteFileException {
        YearsJson years = yearsInstance.getEnglishBooksByYears();
        JSON json = new JSON();
        json.write("src\\test\\resources\\out\\years.json", years);
        assertTrue((new File("src\\test\\resources\\out\\years.json")).exists());
    }
}
