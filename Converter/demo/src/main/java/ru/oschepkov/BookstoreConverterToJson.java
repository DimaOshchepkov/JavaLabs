package ru.oschepkov;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.*;

public class BookstoreConverterToJson implements IConverterXML {

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
        // doc = command.invoke(doc);
        writeJsonToFile(convertDocumentToJson(doc), pathJson);
    }

    @Override
    public void convert(String pathXml, IBookstoreTransformationCommand command) throws Exception {
        convert(pathXml, "demo\\src\\main\\resourses\\out.json", command);
    }

    private JSONObject convertDocumentToJson(Document document) {
        JSONObject json = new JSONObject();

        // Получаем корневой элемент
        Element rootElement = document.getDocumentElement();

        // Рекурсивно преобразуем элемент в JSON
        convertElementToJson(rootElement, json);

        return json;
    }

    private static void writeJsonToFile(JSONObject json, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertElementToJson(Element element, JSONObject json) {
    NodeList childNodes = element.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
        Node node = childNodes.item(i);

        if (node.getNodeType() == Node.TEXT_NODE) {
            String value = node.getNodeValue().trim();
            if (!value.isEmpty()) {
                json.put("value", value);
            }
        } else if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element childElement = (Element) node;
            String childElementName = childElement.getNodeName();
            JSONObject childJson = new JSONObject();

            // Проверяем, существует ли уже ключ с таким именем
            if (json.containsKey(childElementName)) {
                // Если существует, и это не массив, превращаем в массив
                if (!(json.get(childElementName) instanceof JSONArray)) {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(json.get(childElementName));
                    jsonArray.add(childJson);
                    json.put(childElementName, jsonArray);
                } else {
                    // Если это массив, добавляем новый объект к массиву
                    ((JSONArray) json.get(childElementName)).add(childJson);
                }
            } else {
                // Если ключа нет, просто добавляем его
                json.put(childElementName, childJson);
            }

            convertElementToJson(childElement, childJson);
        }
    }
}
}
