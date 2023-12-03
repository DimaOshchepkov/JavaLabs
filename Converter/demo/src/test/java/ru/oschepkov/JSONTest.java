package ru.oschepkov;

import static org.junit.Assert.assertEquals;
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
        json.write("src\\test\\resources\\out\\bookstore.json", years);
        assertTrue((new File("src\\test\\resources\\out\\bookstore.json")).exists());
    }

    @Test
    public void testWriteEnglish() throws WriteFileException {
        YearsJson years = yearsInstance.getEnglishBooksByYears();
        JSON json = new JSON();
        json.write("src\\test\\resources\\out\\years.json", years);
        assertTrue((new File("src\\test\\resources\\out\\years.json")).exists());
    }

    @Test
    public void testWriteRussianUtf_16() throws WriteFileException {
        YearsJson years = yearsInstance.getRussianBooksByYears();
        JSON json = new JSON("utf-16");
        json.write("src\\test\\resources\\out\\booksByYearsUtf_16.json", years);
        assertTrue((new File("src\\test\\resources\\out\\booksByYearsUtf_16.json")).exists());
    }

    @Test
    public void testWriteRussianWindow_1251() throws WriteFileException {
        YearsJson years = yearsInstance.getRussianBooksByYears();
        JSON json = new JSON("windows-1251");
        json.write("src\\test\\resources\\out\\booksByYearsWindows_1251.json", years);
        assertTrue((new File("src\\test\\resources\\out\\booksByYearsWindows_1251.json")).exists());
    }

    @Test
    public void testRussianReadWindows_1251() throws ReadFileException {
        JSON json = new JSON("windows-1251");
        YearsJson years= json.read("src\\test\\resources\\input\\booksByYearsWindows_1251.json");
        assertEquals(years.getYears().get(0).getBooks().get(0).getCategory(), "Фантастика");
    }

    @Test
    public void testRussianReadUtf_16() throws ReadFileException {
        JSON json = new JSON("utf-16");
        YearsJson years= json.read("src\\test\\resources\\input\\booksByYearsUtf_16.json");
        assertEquals(years.getYears().get(0).getBooks().get(0).getCategory(), "Фантастика");
    }
}
