package ru.oschepkov;

import java.io.IOException;

import ru.oschepkov.Validators.BookstoreValidator;
import ru.oschepkov.Validators.IValidator;

public class BookstoreConverterToJson implements IConverter {

    final IValidator bookStoreValXml;
    final SerializeToJson serializerToJson;
    final DeserializerFromXml deserializerFromXml;
    final MapperBookstore mapperBookStore;

    BookstoreConverterToJson() throws Exception {
        bookStoreValXml = new BookstoreValidator();
        serializerToJson = new SerializeToJson();
        deserializerFromXml = new DeserializerFromXml();
        mapperBookStore = new MapperBookstore();
    }

    @Override
    public void convert(String pathXml, String pathJson) {
        try {
            ru.oschepkov.BookstoreStruct.Bookstore bookstore = deserializerFromXml.apply(pathXml);
            serializerToJson.apply(pathJson, mapperBookStore.convert(bookstore));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void convert(String pathXml) throws Exception {
        convert(pathXml, "src\\main\\resourses\\out.json");
    }
}
