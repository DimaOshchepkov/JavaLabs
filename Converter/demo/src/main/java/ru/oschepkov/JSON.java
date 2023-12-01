package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;
import ru.oschepkov.years.YearsJson;

public class JSON implements IWriter, IReader {

    ObjectMapper jsonMapper = new ObjectMapper();
    ObjectWriter writer;
    JSON() {
        writer = jsonMapper.writerWithDefaultPrettyPrinter();
    }
    
    /** 
     * @param path путь до файла, в который будет записан объект
     * @param obj объект
     * @throws WriteFileException
     */
    @Override
    public void write(String path, Object obj) throws WriteFileException{  
        try{ 
            writer.writeValue(new File(path), obj);
        }
        catch (IOException exception) {
            throw new WriteFileException("Ошибка записи в файл", exception);
        }
    }

    /** 
     * @param path путь до файла для конвертации
     * @return YearsJson
     * @throws ReadFileException
     */
    @Override
    public YearsJson read(String path) throws ReadFileException {
        try {
        return jsonMapper.readValue(new File(path), YearsJson.class);
        }
        catch (IOException exception) {
            throw new ReadFileException("Ошибка записи в файл", exception);
        }
    }
    
}
