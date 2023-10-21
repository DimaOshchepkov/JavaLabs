package ru.oschepkov;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class BookstoreConverterToJson implements IConverterXML{

    final IValidator bookStoreVal;
    IReaderDOM reader;

    BookstoreConverterToJson(BookstoreValidator validator, IReaderDOM readerDOM) {
        bookStoreVal = validator;
        reader = readerDOM;
    }

    @Override
    public void convert(String path, IBookstoreTransformationCommand command) throws Exception {
        if (!bookStoreVal.isValid(path))
            throw new Exception("incorrect xmd schema of file");
        
        Document doc = reader.read(path);
        command.invoke(doc);
        convertDocumentToJson(doc);
    }

     public static JsonObject convertDocumentToJson(Document document) {
        JsonObject json = new JsonObject();

        // Получаем корневой элемент
        Element rootElement = document.getDocumentElement();

        // Рекурсивно преобразуем элемент в JSON
        convertElementToJson(rootElement, json);

        return json;
    }

    public static void convertElementToJson(Element element, JsonObject json) {
        NodeList childNodes = element.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                JsonObject childJson = new JsonObject();
                convertElementToJson(childElement, childJson);
                json.add(childElement.getNodeName(), childJson);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                json.addProperty("value", node.getNodeValue());
            }
        }

        NamedNodeMap attributes = element.getAttributes();

        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Attr attribute = (Attr) attributes.item(i);
                json.addProperty(attribute.getName(), attribute.getValue());
            }
        }
    }
    
}
