package ru.oschepkov;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        IConverterXML parser = new BookstoreConverterToJson(new BookstoreValidator(), new ReaderDOM());
        parser.convert("demo\\src\\main\\resourses\\OriginalXML.xml", new ClassificationByYears());
    }
}
