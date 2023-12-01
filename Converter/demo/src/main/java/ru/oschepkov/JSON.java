package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ru.oschepkov.BookstoreNewStruct.YearsJson;

public class JSON implements IWriter, IReader {

    ObjectMapper jsonMapper = new ObjectMapper();
    ObjectWriter writer;
    JSON() {
        writer = jsonMapper.writerWithDefaultPrettyPrinter();
    }
    
    /** 
     * @param path путь до файла, в который будет записан объект
     * @param obj объект
     * @throws IOException
     */
    @Override
    public void write(String path, Object obj) throws IOException{   
        writer.writeValue(new File(path), obj);
    }

    /** 
     * @param path путь до файла для конвертации
     * @return YearsJson
     * @throws IOException
     */
    @Override
    public YearsJson read(String path) throws IOException {
        return jsonMapper.readValue(new File(path), YearsJson.class);
    }
    
}
