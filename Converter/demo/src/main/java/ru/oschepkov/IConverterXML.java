package ru.oschepkov;


public interface IConverterXML {
    public void convert(String path, String pathJson, IBookstoreTransformationCommand command) throws Exception;
    public void convert(String pathXml, IBookstoreTransformationCommand command) throws Exception;
}
