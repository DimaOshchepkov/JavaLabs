package ru.oschepkov;

import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.UnknownFileTypeException;

@Slf4j
public class FabricConverter {

    private FabricConverter() {
    }

    private static FabricConverter instance = null;

    /**
     * Получить экземпляр класса
     * 
     * @return FabricConverter
     */
    public static FabricConverter getInstance() {
        if (instance == null) {
            instance = new FabricConverter();
        }
        return instance;
    }

    /**
     * @param sourcePath     путь до файла конвертации
     *                       Если файл .xml, то конвертер переводит .xml в .json,
     *                       иначе .json в .xml
     * @param sourceEncoding кодировка конвертируемого файла (utf-8, utf-16,
     *                       windows-1251,...)
     * @param targetEncoding кодировка конченого файла (utf-8, utf-16,
     *                       windows-1251,...)
     * @return IConverter
     * @throws IOException
     * @throws ReadFileException
     * @throws UnknownFileTypeException
     */
    public Converter create(final String sourcePath, final String sourceEncoding, final String targetEncoding)
            throws ReadFileException, UnknownFileTypeException {
        
        FileType fileType;
        try (FileReader r = new FileReader(sourcePath)) {
            final int character = r.read();
            if (character == -1) {
                log.warn("Файл пуст");
                fileType = determineFileTypeByExtention(sourcePath);
            } else {
                fileType = determineFileTypeByFirstSymbol((char) character);
            }

            IReader reader;
            IWriter writer;
            switch (fileType) {
                case FileType.XML -> {
                    reader = new XML(sourceEncoding);
                    writer = new JSON(targetEncoding);
                }
                case FileType.JSON -> {
                    reader = new JSON(targetEncoding);
                    writer = new XML(sourceEncoding);
                }
                default -> 
                    throw new UnknownFileTypeException("Неизвестный тип файла");
            }
            return Converter.builder()
                    .reader(reader)
                    .writer(writer)
                    .mapper(new MapperBookstore())
                    .build();
        } catch (final IOException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Не удалось считать файл", exception);

        }
    }

    /**
     * @param sourcePath путь до файла конвертации
     *                   Если файл .xml, то конвертер переводит .xml в .json,
     *                   иначе .json в .xml
     * @return Converter
     * @throws ReadFileException
     * @throws UnknownFileTypeException
     */
    public Converter create(final String sourcePath)
            throws ReadFileException, UnknownFileTypeException {
        return create(sourcePath, "utf-8", "utf-8");
    }

    private FileType determineFileTypeByFirstSymbol(final char character) throws UnknownFileTypeException {
        switch (character) {
            case '<' -> {
                return FileType.XML;
            }
            case '{' -> {
                return FileType.JSON;
            }
            default -> {
                log.error("Неизвестный тип файла");
                throw new UnknownFileTypeException("Неизвестный тип файла");
            }
        }
    }

    private FileType determineFileTypeByExtention(final String sourcePath) throws UnknownFileTypeException {
        if (sourcePath.endsWith(".xml")) {
            return FileType.XML;
        } else if (sourcePath.endsWith(".json")) {
            return FileType.JSON;
        } else {
            log.error("Неизвестный тип файла");
            throw new UnknownFileTypeException("Неизвестный тип файла");
        }
    }

    private enum FileType {
        XML,
        JSON,
    }
}
