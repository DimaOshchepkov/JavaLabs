package ru.oschepkov;

import ru.oschepkov.Validators.BookstoreValidator;
import ru.oschepkov.Validators.IValidator;

public class BookstoreConverterToJson implements IConverterXML {

    final IValidator bookStoreValXml;
    final SerializeToJson serializerToJson;
    final DeserializerFromXml deserializerFromXml;
    final IMapperBookstore mapperBookStore;

    BookstoreConverterToJson() throws Exception {
        bookStoreValXml = new BookstoreValidator();
        serializerToJson = new SerializeToJson();
        deserializerFromXml = new DeserializerFromXml();
        mapperBookStore = new IMapperBookstoreImpl();
    }

    @Override
    public void convert(String pathXml, String pathJson) throws Exception {
        if (!bookStoreValXml.isValid(pathXml))
            throw new Exception("incorrect xsd schema of file");

        ru.oschepkov.BookstoreStruct.Bookstore bookstore = deserializerFromXml.apply(pathXml);
        serializerToJson.apply(pathJson, mapperBookStore.convert(bookstore));
    }

    @Override
    public void convert(String pathXml) throws Exception {
        convert(pathXml, "src\\main\\resourses\\out.json");
    }
}
