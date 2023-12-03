package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import lombok.val;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.UnknownFileTypeException;
import ru.oschepkov.converterexeption.WriteFileException;

public class ConverterTest {
    @Test
    public void testConvertToJson() throws ReadFileException, UnknownFileTypeException, WriteFileException {
        val source = "src\\test\\resources\\input\\RussianBookstore.xml";
        val target = "src\\test\\resources\\out\\RussianBookstore.json";
        val conv = FabricConverter.getInstance().create(source);
        conv.convert(source, target);
        assertTrue((new File(target)).exists());
    }

    @Test
    public void testConvertToXml() throws ReadFileException, UnknownFileTypeException, WriteFileException {
        val source = "src\\test\\resources\\input\\EnglishBooksByYears.json";
        val target = "src\\test\\resources\\out\\EnglishBooksByYears.xml";
        val conv = FabricConverter.getInstance().create(source);
        conv.convert(source, target);
        assertTrue((new File(target)).exists());
    }
}
