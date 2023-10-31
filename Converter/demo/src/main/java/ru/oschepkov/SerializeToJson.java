package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeToJson {
    ObjectMapper objectMapper = new ObjectMapper();

    void apply(String path, Object obj) throws IOException {
        objectMapper.writeValue(new File(path), obj);
    }
}
