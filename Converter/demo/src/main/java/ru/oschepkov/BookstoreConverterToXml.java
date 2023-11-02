package ru.oschepkov;

import java.io.IOException;

import ru.oschepkov.Validators.BookstoreValidator;
import ru.oschepkov.Validators.IValidator;


public class BookstoreConverterToXml implements IConverter{

    final IValidator bookStoreValJson;
    final SerializerToXml serializerToXml;
    final DeserializerFromJson deserializerFromJson;
    final MapperBookstore mapperBookStore;

    BookstoreConverterToXml() throws Exception {
        bookStoreValJson = new BookstoreValidator();
        serializerToXml = new SerializerToXml();
        deserializerFromJson = new DeserializerFromJson();
        mapperBookStore = new MapperBookstore();
    }

    @Override
    public void convert(String pathXml, String pathJson){

        try {
            ru.oschepkov.BookstoreNewStruct.Years bookstore = deserializerFromJson.apply(pathXml);
            serializerToXml.apply(pathJson, mapperBookStore.convert(bookstore));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void convert(String pathXml){
        convert(pathXml, "src\\main\\resourses\\out.json");
    }  
}
