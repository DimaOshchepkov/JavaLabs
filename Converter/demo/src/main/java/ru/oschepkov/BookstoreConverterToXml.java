package ru.oschepkov;

import ru.oschepkov.Validators.BookstoreValidator;
import ru.oschepkov.Validators.IValidator;


public class BookstoreConverterToXml implements IConverter{

    final IValidator bookStoreValJson;
    final SerializerToXml serializerToXml;
    final DeserializerFromJson deserializerFromJson;
    final IMapperBookstore mapperBookStore;

    BookstoreConverterToXml() throws Exception {
        bookStoreValJson = new BookstoreValidator();
        serializerToXml = new SerializerToXml();
        deserializerFromJson = new DeserializerFromJson();
        mapperBookStore = new IMapperBookstoreImpl();
    }

    @Override
    public void convert(String pathXml, String pathJson) throws Exception {
        if (!bookStoreValJson.isValid(pathXml))
            throw new Exception("incorrect xsd schema of file");

        ru.oschepkov.BookstoreNewStruct.Bookstore bookstore = deserializerFromJson.apply(pathXml);
        serializerToXml.apply(pathJson, mapperBookStore.convert(bookstore));
    }

    @Override
    public void convert(String pathXml) throws Exception {
        convert(pathXml, "src\\main\\resourses\\out.json");
    }  
}
