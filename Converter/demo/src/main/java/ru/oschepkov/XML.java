package ru.oschepkov;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;

@Slf4j
public class XML implements IReader, IWriter {

    XmlMapper xmlMapper = new XmlMapper();
    String encoding;
    XML(final String encoding) {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.encoding = encoding;
    }

    XML() {
        this("UTF-8");
    }
    
    /** 
     * @param path путь до файла для записи
     * @param obj объект для записи
     * @throws WriteFileException
     */
    @Override
    public void write(final String path, final Object obj) throws WriteFileException {
        try (OutputStream outputStream = new FileOutputStream(new File(path))) {
            val writer = new OutputStreamWriter(outputStream, encoding);
            xmlMapper.writeValue(writer, obj);
        }
        catch (final UnsupportedEncodingException exception) {
            log.error(exception.getMessage(), exception);
            throw new WriteFileException("Данная кодировка не поддерживается", exception);
        }
        catch (final IOException exception) {
            log.error(exception.getMessage(), exception);
            throw new WriteFileException("Ошибка записи в файл", exception);
        }
    }

    /** 
     * @param path путь до считываемого файла
     * @return BookstoreXml
     * @throws ReadFileException
     */
    @Override
    public BookstoreXml read(final String path) throws ReadFileException {
        try (InputStream inputStream = new FileInputStream(new File(path))) {
            val reader = new InputStreamReader(inputStream, encoding);
            return xmlMapper.readValue(reader, BookstoreXml.class);
        }
        catch (final UnsupportedEncodingException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Данная кодировка не поддерживается", exception);
        }
        catch(final IOException exception) {
            log.error(exception.getMessage(), exception);
            throw new ReadFileException("Ошибка чтения файла", exception);
        }
    }
}
