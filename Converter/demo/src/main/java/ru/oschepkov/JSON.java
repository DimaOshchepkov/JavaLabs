package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.oschepkov.BookstoreNewStruct.YearsJson;

public class JSON implements IWriter, IReader {

    XmlMapper xmlMapper = new XmlMapper();
    JSON() {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /** 
     * @param path путь до файла, в который будет записан объект
     * @param obj объект
     * @throws IOException
     */
    @Override
    public void write(String path, Object obj) throws IOException{  
        xmlMapper.writeValue(new File(path), obj);
    }

    ObjectMapper jsonMapper = new ObjectMapper();

    
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
