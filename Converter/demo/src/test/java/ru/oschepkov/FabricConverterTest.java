package ru.oschepkov;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import lombok.val;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.UnknownFileTypeException;

public class FabricConverterTest {

    @Before
    public void setUp() {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
    }

    @Test
    public void testCreate() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        val source = "src\\test\\resources\\input\\EnglishBookstore.xml";

        val fabricConverter = FabricConverter.getInstance();
        val conv = fabricConverter.create(source);

        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); 

        assertTrue(readerField.get(conv) instanceof XML);
        assertTrue(!(readerField.get(conv) instanceof JSON));
    }

    @Test
    public void testCreateWrongTypeExtension() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        val source = "src\\test\\resources\\input\\correctXml.txt";

        val fabricConverter = FabricConverter.getInstance();
        val conv = fabricConverter.create(source);

        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); 

        assertTrue(readerField.get(conv) instanceof XML);
        assertTrue(!(readerField.get(conv) instanceof JSON));
    }

    @Test
    public void testCreateEmptyJson() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        val source = "src\\test\\resources\\input\\emptyJson.json";

        val fabricConverter = FabricConverter.getInstance();
        val conv = fabricConverter.create(source);

        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); 

        assertTrue(readerField.get(conv) instanceof JSON);
        assertTrue(!(readerField.get(conv) instanceof XML));
    }

    @Test
    public void testCreate_WithUnknownFileTypeException() {

        val invalidPath = "src\\test\\resources\\testerrors\\commonText.txt";
        val fabricConverter = FabricConverter.getInstance();

        assertThrows(UnknownFileTypeException.class, () -> {
            fabricConverter.create(invalidPath);
        });
    }

    @Test
    public void testCreate_WithReadFileException() {

        val nonExistentPath = "path/to/nonexistent/file.xml";
        val fabricConverter = FabricConverter.getInstance();

        assertThrows(ReadFileException.class, () -> {
            fabricConverter.create(nonExistentPath);
        });
    }
}
