package ru.oschepkov;


public interface IConverterXML {
    public void convert(String path, String pathJson, IBookstoreTransformationCommand command) throws Exception;
}
