package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.UnknownFileTypeException;
import ru.oschepkov.converterexeption.WriteFileException;

public class ConverterTest {
    @Test
    public void testConvertToJson() throws ReadFileException, UnknownFileTypeException, WriteFileException {
        String source = "src\\test\\resources\\input\\RussianBookstore.xml";
        String target = "src\\test\\resources\\out\\RussianBookstore.json";
        Converter conv = FabricConverter.getInstance().create(source);
        conv.convert(source, target);
        assertTrue((new File(target)).exists());
    }

    @Test
    public void testConvertToXml() throws ReadFileException, UnknownFileTypeException, WriteFileException {
        String source = "src\\test\\resources\\input\\EnglishBooksByYears.json";
        String target = "src\\test\\resources\\out\\EnglishBooksByYears.xml";
        Converter conv = FabricConverter.getInstance().create(source);
        conv.convert(source, target);
        assertTrue((new File(target)).exists());
    }
}
