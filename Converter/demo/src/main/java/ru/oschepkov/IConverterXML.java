package ru.oschepkov;


public interface IConverterXML {
    public void convert(String path, String pathJson) throws Exception;
    public void convert(String pathXml) throws Exception;
}
