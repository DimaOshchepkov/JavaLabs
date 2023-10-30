package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class BookstoreValidator implements IValidator  {

    SchemaFactory sFactory;
    Schema schema;
    Validator validator;
    BookstoreValidator() throws ParserConfigurationException, SAXException {
        init("src\\main\\resourses\\xsdSchema.xsd");
    }

    BookstoreValidator(String xsd) throws ParserConfigurationException, SAXException {
        init(xsd);
    }

    private void init(String xsd) throws ParserConfigurationException, SAXException {
        pathToXsd = xsd;
        sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schema = sFactory.newSchema(new File(pathToXsd));
        validator = schema.newValidator();
    }

    String pathToXsd;
    @Override
    public boolean isValid(String path) {
         try {
            validator.validate(new StreamSource(new File(path)));
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}
