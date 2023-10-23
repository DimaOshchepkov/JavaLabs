package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import ru.oschepkov.BookstoreStruct.Author;
import ru.oschepkov.BookstoreStruct.Book;
import ru.oschepkov.BookstoreStruct.Bookstore;
import ru.oschepkov.BookstoreStruct.Characters;
import ru.oschepkov.BookstoreStruct.Character;
import ru.oschepkov.BookstoreStruct.Price;
import ru.oschepkov.BookstoreStruct.Title;
import ru.oschepkov.BookstoreStruct.Year;

public class BookstoreTest {

    JAXBContext context;
    Marshaller marshaller;
    BookstoreValidator validator;


    public BookstoreTest() throws JAXBException, ParserConfigurationException, SAXException{
        context = JAXBContext.newInstance(Bookstore.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        validator = new BookstoreValidator();
    }

    @Test
    public void structTest() throws JAXBException, ParserConfigurationException, SAXException
    {
         // Создаем объекты и заполняем данными
            List<Character> characters1 = new ArrayList<>();
            characters1.add(new Character("Harry Potter", "Protagonist"));
            characters1.add(new Character("Hermione Granger", "Supporting"));
            characters1.add(new Character("Ron Weasley", "Supporting"));

            List<Character> characters2 = new ArrayList<>();
            characters2.add(new Character("Paul Atreides", "Protagonist"));
            characters2.add(new Character("Liet-Kynes", "Supporting"));
            characters2.add(new Character("Baron Vladimir Harkonnen", "Antagonist"));

            Bookstore bookstore = new Bookstore();
            bookstore.setBooks(new ArrayList<>());

            Book book1 = new Book();
            book1.setCategory("Fantasy");
            book1.setTitle(new Title("en", "Harry Potter and the Philosopher's Stone"));
            book1.setAuthor(new Author("J.K. Rowling"));
            book1.setYear(new Year("1997"));
            book1.setPrice(new Price("USD", "20.00"));
            book1.setCharacters(new Characters(characters1));

            Book book2 = new Book();
            book2.setCategory("Science Fiction");
            book2.setTitle(new Title("en", "Dune"));
            book2.setAuthor(new Author("Frank Herbert"));
            book2.setYear(new Year("1965"));
            book2.setPrice(new Price("USD", "25.00"));
            book2.setCharacters(new Characters(characters2));

            bookstore.getBooks().add(book1);
            bookstore.getBooks().add(book2);

            // Маршализуем объекты в XML и сохраняем в файл
            marshaller.marshal(bookstore, new File("src\\main\\resourses\\bookstoreStructTest.xml"));
            assertTrue(validator.isValid("src\\main\\resourses\\bookstoreStructTest.xml"));
    }
}