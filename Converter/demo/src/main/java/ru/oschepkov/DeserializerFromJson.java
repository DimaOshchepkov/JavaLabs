package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.oschepkov.BookstoreNewStruct.Bookstore;

public class DeserializerFromJson {
    ObjectMapper jsonMapper = new ObjectMapper();
    Bookstore apply(String path) throws IOException{
        File file = new File(path);
        return jsonMapper.readValue(file, Bookstore.class);
    }
}
