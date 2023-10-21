package ru.oschepkov;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        SpecialReaderXml r = new SpecialReaderXml();
        r.read("demo\\src\\main\\resourses\\OriginalXML.xml");
    }
}
