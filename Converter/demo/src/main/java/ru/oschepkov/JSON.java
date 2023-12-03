package ru.oschepkov;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;
import ru.oschepkov.years.YearsJson;

@Slf4j
public class JSON implements IWriter, IReader {

    private ObjectMapper jsonMapper = new ObjectMapper();
    private ObjectWriter writerObj;
    private String encoding;
    JSON() {
        this("utf-8");
    }

    JSON(String encoding) {
        writerObj = jsonMapper.writerWithDefaultPrettyPrinter();
        this.encoding = encoding;
    }
    
    /** 
     * @param path путь до файла, в который будет записан объект
     * @param obj объект
     * @throws WriteFileException
     */
    @Override
    public void write(String path, Object obj) throws WriteFileException{  
        try (OutputStream outputStream = new FileOutputStream(new File(path))){ 
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, encoding);
            writerObj.writeValue(writer, obj);
        }
        catch (UnsupportedEncodingException exception) {
            log.error(exception.getMessage(), exception);
            throw new WriteFileException("Данная кодировка не поддерживается", exception);
        }
        catch (IOException exception) {
            log.error(exception.getMessage(), exception);
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
        try (InputStream inputStream = new FileInputStream(new File(path))){
            InputStreamReader reader = new InputStreamReader(inputStream, encoding);
            return jsonMapper.readValue(reader, YearsJson.class);
        }
        catch (UnsupportedEncodingException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Данная кодировка не поддерживается", exception);
        }
        catch (IOException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Ошибка записи в файл", exception);
        }
    }
    
}
