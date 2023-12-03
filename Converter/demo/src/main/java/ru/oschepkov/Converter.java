package ru.oschepkov;

import lombok.Builder;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;
import ru.oschepkov.years.YearsJson;

@Builder
public class Converter{
    
    private IReader reader;
    private IWriter writer;
    private MapperBookstore mapper;

    
    /** Конвертирует исходный файл в целевой source -> target
     * @param sourcePath
     * @param targetPath
     * @throws ReadFileException
     * @throws WriteFileException
     */
    public void convert(String sourcePath, String targetPath) throws ReadFileException, WriteFileException {
        Object obj = reader.read(sourcePath);
        switch (obj) {
            case BookstoreXml bookstore -> writer.write(targetPath, mapper.convert(bookstore));
            case YearsJson years -> writer.write(targetPath,  mapper.convert(years));
            default -> throw new ReadFileException("Файл не удовлетворяет требуемой структуре");
        }
    }
}
