package ru.oschepkov;

import lombok.Builder;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;
import ru.oschepkov.years.YearsJson;

@Builder
public class Converter{
    
    private final IReader reader;
    private final IWriter writer;
    private final MapperBookstore mapper;

    
    /** Конвертирует исходный файл в целевой source -> target
     * @param sourcePath
     * @param targetPath
     * @throws ReadFileException
     * @throws WriteFileException
     */
    public void convert(final String sourcePath, final String targetPath) throws ReadFileException, WriteFileException {
        switch (reader.read(sourcePath)) {
            case final BookstoreXml bookstore -> writer.write(targetPath, mapper.convert(bookstore));
            case final YearsJson years -> writer.write(targetPath,  mapper.convert(years));
            default -> throw new ReadFileException("Файл не удовлетворяет требуемой структуре");
        }
    }
}
