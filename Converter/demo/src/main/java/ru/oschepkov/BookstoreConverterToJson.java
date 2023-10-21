package ru.oschepkov;

import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.*;


public class BookstoreConverterToJson implements IConverterXML{

    final IValidator bookStoreVal;
    IReaderDOM reader;

    BookstoreConverterToJson(BookstoreValidator validator, IReaderDOM readerDOM) {
        bookStoreVal = validator;
        reader = readerDOM;
    }

    @Override
    public void convert(String pathXml, String pathJson, IBookstoreTransformationCommand command) throws Exception {
        if (!bookStoreVal.isValid(pathXml))
            throw new Exception("incorrect xsd schema of file");
        
        Document doc = reader.read(pathXml);
        doc = command.invoke(doc);
        writeJsonToFile(convertDocumentToJson(doc).toString(), pathJson);
    }

    @Override
    public void convert(String pathXml, IBookstoreTransformationCommand command) throws Exception {
        convert(pathXml, "demo\\src\\main\\resourses", command);
    }

    private JsonObject convertDocumentToJson(Document document) {
        JsonObject json = new JsonObject();

        // Получаем корневой элемент
        Element rootElement = document.getDocumentElement();

        // Рекурсивно преобразуем элемент в JSON
        convertElementToJson(rootElement, json);

        return json;
    }

    private static void writeJsonToFile(String json, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
