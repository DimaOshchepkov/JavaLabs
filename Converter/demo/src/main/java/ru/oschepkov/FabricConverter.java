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

    public static FabricConverter getInstance() {
        if (instance == null) {
            instance = new FabricConverter();
        }
        return instance;
    }

    /**
     * @param sourcePath путь до файла конвертации
     *                   Если файл .xml, то конвертер переводит .xml в .json,
     *                   иначе .json в .xml
     * @return IConverter
     * @throws IOException
     * @throws ReadFileException
     * @throws UnknownFileTypeException
     */
    public Converter create(String sourcePath) throws ReadFileException, UnknownFileTypeException {
        IReader reader;
        IWriter writer;
        try (FileReader r = new FileReader(sourcePath)) {
            int character = r.read();
            if (character == -1) {
                log.warn("Файл пуст");
                if (sourcePath.endsWith(".xml")) {
                    reader = new XML();
                    writer = new JSON();
                } else if (sourcePath.endsWith(".json")) {
                    reader = new JSON();
                    writer = new XML();
                } else {
                    log.error("Неизвестный тип файла");
                    throw new UnknownFileTypeException("Неизвестный тип файла");
                }
            } else {
                switch ((char) character) {
                    case '<' -> {
                        reader = new XML();
                        writer = new JSON();
                    }
                    case '{' -> {
                        reader = new JSON();
                        writer = new XML();
                    }
                    default -> {
                        log.error("Неизвестный тип файла");
                        throw new UnknownFileTypeException("Неизвестный тип файла");
                    }
                }
            }
            return Converter.builder()
                    .reader(reader)
                    .writer(writer)
                    .mapper(new MapperBookstore())
                    .build();
        } catch (IOException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Не удалось считать файл", exception);
            
        }

    }
}
