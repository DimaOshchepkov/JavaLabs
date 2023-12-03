package ru.oschepkov;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.UnknownFileTypeException;

public class FabricConverterTest {

    @Before
    public void setUp() {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        // Дополнительные настройки для тестов
    }

    @Test
    public void testCreate() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        String source = "src\\test\\resources\\input\\EnglishBookstore.xml";

        FabricConverter fabricConverter = FabricConverter.getInstance();
        Converter conv = fabricConverter.create(source);

        // Получение поля reader
        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); // Разрешение доступа к приватному полю

        assertTrue(readerField.get(conv) instanceof XML);
        assertTrue(!(readerField.get(conv) instanceof JSON));
    }

    @Test
    public void testCreateWrongTypeExtension() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        String source = "src\\test\\resources\\input\\correctXml.txt";

        FabricConverter fabricConverter = FabricConverter.getInstance();
        Converter conv = fabricConverter.create(source);

        // Получение поля reader
        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); // Разрешение доступа к приватному полю

        assertTrue(readerField.get(conv) instanceof XML);
        assertTrue(!(readerField.get(conv) instanceof JSON));
    }

    @Test
    public void testCreateEmptyJson() throws ReadFileException, UnknownFileTypeException, NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        String source = "src\\test\\resources\\input\\emptyJson.json";

        FabricConverter fabricConverter = FabricConverter.getInstance();
        Converter conv = fabricConverter.create(source);

        // Получение поля reader
        Field readerField = Converter.class.getDeclaredField("reader");
        readerField.setAccessible(true); // Разрешение доступа к приватному полю

        assertTrue(readerField.get(conv) instanceof JSON);
        assertTrue(!(readerField.get(conv) instanceof XML));
    }

    @Test
    public void testCreate_WithUnknownFileTypeException() {

        // Укажите путь к файлу неподдерживаемого типа
        String invalidPath = "src\\test\\resources\\testerrors\\commonText.txt";

        // Создание экземпляра FabricConverter
        FabricConverter fabricConverter = FabricConverter.getInstance();

        // Проверка на выбрасывание исключения UnknownFileTypeException
        assertThrows(UnknownFileTypeException.class, () -> {
            fabricConverter.create(invalidPath);
        });
    }

    @Test
    public void testCreate_WithReadFileException() {
        // Укажите путь к файлу, который не существует
        String nonExistentPath = "path/to/nonexistent/file.xml";

        // Создание экземпляра FabricConverter
        FabricConverter fabricConverter = FabricConverter.getInstance();

        // Проверка на выбрасывание исключения ReadFileException
        assertThrows(ReadFileException.class, () -> {
            fabricConverter.create(nonExistentPath);
        });
    }
}
